package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Specimen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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



    @Value("${REFERENCE_SPECIMEN_CODE}")
    private String REFERENCE_SPECIMEN_CODE; // This specific
    // specimen needs to have non-null country and biogeographic region so they can be replaced by a proxy. If any
    // were to be null (in the database) they would get null value and thus the isLoaded method would return True.

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpecimenRepository specimenRepository;


    @Qualifier("arilabdbEntityManagerFactory")
    @Autowired
    EntityManager entityManager;

    @Test
    public void repositoryWorks() {
       List<Specimen> specimens = specimenRepository.findAll();
    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void specimenEntityGraphIsAppliedOnFindByCode() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Optional<Specimen> optSpecimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE);
        Specimen specimen = optSpecimen.get();
        assertTrue(persistenceUtil.isLoaded(specimen, "locality"));
        assertTrue(persistenceUtil.isLoaded(specimen, "collectionEvent"));
        assertNotNull(specimen.getCollectionEvent().getLocality().getCountry().getCountryName()); // This should
        // work. As the country name is the @Id field, and used as a foreign key, the object is not initialized. In
        // fact, if an initialization is needed, this will fail as this test is outside of a transaction, hence only
        // the findBySpecimenCode method will run in a transaction.



        // Basis of record should be unloaded
        assertFalse(persistenceUtil.isLoaded(specimen,"basisOfRecord"));
        // Accessing basis of record id field should not initialize the object
        String temp = specimen.getBasisOfRecord().getBasisOfRecord();
        assertFalse(persistenceUtil.isLoaded(specimen,"basisOfRecord"));

        // Accessing a non-Id field should initialize the object
        String countryCode = specimen.getCollectionEvent().getLocality().getCountry().getCountryCode();
        assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));

        // Species should be loaded
        assertTrue(persistenceUtil.isLoaded(specimen, "species"));
    }


    @Test
    @Transactional("arilabdbTransactionManager")
    public void specimenEntityGraphFetchBasicIsAppliedOnFindAll() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        List<Specimen> specimenList = specimenRepository.findAll();
        // Get only a specific specimen to use for the tests
        Optional<Specimen> optionalSpecimen = getReferenceSpecimenObject(specimenList);
        if (optionalSpecimen.isEmpty()) {
            fail("No reference specimen found in the test database. Can't proceed with test.");
        }

        Specimen specimen = optionalSpecimen.get();

        assertTrue(persistenceUtil.isLoaded(specimen, "locality"));
        assertTrue(persistenceUtil.isLoaded(specimen, "collectionEvent"));
        assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent(), "collectionEventCode"));
        assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"localityCode"));



    }

        private Optional<Specimen> getReferenceSpecimenObject(List<Specimen> specimenList) {
            for (Specimen specimen : specimenList) {
                if (specimen.getSpecimenCode().equals(REFERENCE_SPECIMEN_CODE)) {
                    return Optional.of(specimen);
                }
            }
            return Optional.empty();
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
