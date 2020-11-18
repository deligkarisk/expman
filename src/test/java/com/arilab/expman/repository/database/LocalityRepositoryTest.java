package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.Locality;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocalityRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LocalityRepository localityRepository;

    @Test
    public void localityRepositoryWorks() {
        Integer localities = localityRepository.findAll().size();
        logger.info(String.format("Found %d localities",localities));
    }

    // Failed conditions

    @Test(expected = ConstraintViolationException.class)
    public void noCountryInLocality() {
        Locality locality = new Locality();
        locality.setLocalityCode("TestLocalityCode");
        localityRepository.save(locality);
    }

}
