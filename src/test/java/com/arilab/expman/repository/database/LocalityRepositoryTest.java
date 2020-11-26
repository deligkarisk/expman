package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.Locality;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocalityRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LocalityRepository localityRepository;

    @Test
    public void localityRepositoryWorks() {
        Integer localities = localityRepository.findAll().size();
        logger.info(String.format("Found %d localities", localities));
    }

    // Failed conditions
    @Transactional("arilabdbTransactionManager")
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void noCountryInLocality() {
        Locality locality = new Locality();
        locality.setLocalityCode("TestLocalityCode");
        try {
            localityRepository.saveAndFlush(locality);
        } catch (ConstraintViolationException cve) {
            assertEquals(cve.getConstraintViolations().size(), 1); // Ensures that there is only one constraint
            // violation.
            throw cve;
        }

    }
}
