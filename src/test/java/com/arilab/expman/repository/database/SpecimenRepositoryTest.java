package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Specimen;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public void entityGraphIsApplied() {
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Optional<Specimen> optSpecimen = specimenRepository.findBySpecimenCode("CASENT0494848"); // This specific
        // specimen has non-null country and biogeographic region so they can be replaced by a proxy. If any were to
        // be null (in the database) they would get null value and thus the isLoaded method would return True.
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

    // Failed conditions
    @Test(expected = ConstraintViolationException.class)
    public void noTypeStatusInSpecimen() {
        Specimen specimen = new Specimen();
        specimen.setSpecimenCode("TestSpecimenCode");
        specimenRepository.save(specimen);



    }


}
