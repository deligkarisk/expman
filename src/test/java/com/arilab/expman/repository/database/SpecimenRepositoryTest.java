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

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
        PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

        Specimen specimen = specimenRepository.findBySpecimenCode("CASENT0233725").get();
        assertFalse(persistenceUtil.isLoaded(specimen,"collectionEvent"));
    }

    // Failed conditions
    @Test(expected = ConstraintViolationException.class)
    public void noTypeStatusInSpecimen() {}


}
