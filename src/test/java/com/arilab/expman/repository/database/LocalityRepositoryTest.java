package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.repository.database.supplementary.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocalityRepositoryTest {

    private String REFERENCE_COUNTRY = "Argentina";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LocalityRepository localityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Test
    public void localityRepositoryWorks() {
        Integer localities = localityRepository.findAll().size();
        logger.info(String.format("Found %d localities", localities));
    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void newLocalityCanBeAdded() {
        Locality locality = new Locality("TestLocalityCode",
                                         countryRepository.findAllByCountryName(REFERENCE_COUNTRY).get());
        localityRepository.saveAndFlush(locality);
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
