package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Species;
import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.repository.database.supplementary.BasisOfRecordRepository;
import com.arilab.expman.repository.database.supplementary.TypeStatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpecimenRepositoryTest {


    private final String REFERENCE_BASIS_OF_RECORD = "Destructive sample";
    private final String REFERENCE_COLLECTION_EVENT_CODE = "ANTC22926";
    private final String REFERENCE_SPECIES_TAXON_CODE = "Pheidole.EPEM188";
    private final String REFERENCE_TYPE_STATUS = "Nontype";

    private final String REFERENCE_SPECIMEN_CODE = "CASENT0494848"; // This specific
    // specimen has non-null country and biogeographic region so they can be replaced by a proxy. If any were to
    // be null (in the database) they would get null value and thus the isLoaded method would return True.

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpecimenRepository specimenRepository;

    @Autowired
    BasisOfRecordRepository basisOfRecordRepository;

    @Autowired
    CollectionEventRepository collectionEventRepository;

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    TypeStatusRepository typeStatusRepository;


    @Qualifier("arilabdbEntityManagerFactory")
    @Autowired
    EntityManager entityManager;

    @Test
    public void repositoryWorks() {
       List<Specimen> specimens = specimenRepository.findAll();
    }

    @Test
    public void specimenEntityGraphIsApplied() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Optional<Specimen> optSpecimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE);
        Specimen specimen = optSpecimen.get();
        assertTrue(persistenceUtil.isLoaded(specimen, "locality"));
        assertTrue(persistenceUtil.isLoaded(specimen, "collectionEvent"));
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"biogeographicRegion"));
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));
        assertFalse(persistenceUtil.isLoaded(specimen,"typeStatus"));
        assertNotNull(specimen.getCollectionEvent().getLocality().getCountry().getCountryName()); // This should
        // work. As the country name is the @Id field, and used as a foreign key, the object is not initialized. In
        // fact, if an initialization is needed, this will fail as this test is outside of a transaction, hence only
        // the findBySpecimenCode method will run in a transaction.
    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void newSpecimenCanBeAdded() {
        BasisOfRecord basisOfRecord = basisOfRecordRepository.findByBasisOfRecord(REFERENCE_BASIS_OF_RECORD).get();
        CollectionEvent collectionEvent =
                collectionEventRepository.findByCollectionEventCode(REFERENCE_COLLECTION_EVENT_CODE).get();
        Species species = speciesRepository.findByTaxonCode(REFERENCE_SPECIES_TAXON_CODE).get();
        TypeStatus typeStatus = typeStatusRepository.findByTypeStatus(REFERENCE_TYPE_STATUS).get();

        Specimen specimen = new Specimen("TestSpecimenCode", typeStatus);
        specimen.setBasisOfRecord(basisOfRecord);
        specimen.setCollectionEvent(collectionEvent);
        specimen.setSpecies(species);

        specimenRepository.saveAndFlush(specimen);

    }

    // Failed conditions
    @Transactional("arilabdbTransactionManager")
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void noTypeStatusInSpecimen() {
        Specimen specimen = new Specimen();
        specimen.setSpecimenCode("TestSpecimenCode");
        try {
            specimenRepository.saveAndFlush(specimen);
        } catch (ConstraintViolationException cve) {
            assertEquals(cve.getConstraintViolations().size(), 1); // Ensures that there is only one constraint
            // violation.
            throw cve;
        }

    }
}
