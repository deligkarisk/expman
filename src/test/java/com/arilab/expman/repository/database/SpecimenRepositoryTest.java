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
import org.springframework.test.context.TestPropertySource;
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
@TestPropertySource(locations = {"classpath:test-references.properties"})
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
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"biogeographicRegion"));
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));
        assertFalse(persistenceUtil.isLoaded(specimen,"typeStatus"));
        assertNotNull(specimen.getCollectionEvent().getLocality().getCountry().getCountryName()); // This should
        // work. As the country name is the @Id field, and used as a foreign key, the object is not initialized. In
        // fact, if an initialization is needed, this will fail as this test is outside of a transaction, hence only
        // the findBySpecimenCode method will run in a transaction.

        // Country should remain unloaded
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));
        // Accessing a non-Id field should initialize the object
        String countryCode = specimen.getCollectionEvent().getLocality().getCountry().getCountryCode();
        assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));

        // Species should be loaded
        assertTrue(persistenceUtil.isLoaded(specimen, "species"));
    }


    @Test
    @Transactional("arilabdbTransactionManager")
    public void specimenEntityGraphIsAppliedOnFindAll() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Specimen specimen = specimenRepository.findAll().get(0);
        assertTrue(persistenceUtil.isLoaded(specimen, "locality"));
        assertTrue(persistenceUtil.isLoaded(specimen, "collectionEvent"));
        //assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent(), "collectionEventCode"));
        //assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"localityCode"));
       // assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"biogeographicRegion"));
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));
        assertFalse(persistenceUtil.isLoaded(specimen,"typeStatus"));
        assertNotNull(specimen.getCollectionEvent().getLocality().getCountry().getCountryName()); // This should
        // work. As the country name is the @Id field, and used as a foreign key, the object is not initialized. In
        // fact, if an initialization is needed, this will fail as this test is outside of a transaction, hence only
        // the findBySpecimenCode method will run in a transaction.

        // Country should remain unloaded
        assertFalse(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));

        // Accessing a non-Id field should initialize the object
        String countryCode = specimen.getCollectionEvent().getLocality().getCountry().getCountryCode();
        assertTrue(persistenceUtil.isLoaded(specimen.getCollectionEvent().getLocality(),"country"));

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
