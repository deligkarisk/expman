package com.arilab.expman.repository.database;


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
public class CtScanRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CtScanRepository ctScanRepository;


    @Test
    public void ctScanRepositoryWorks() {
         Integer numberOfScans = ctScanRepository.findAll().size();
         logger.info(String.format("Found %d CT scans", numberOfScans));
    }


    // Failed conditions

    @Test(expected = ConstraintViolationException.class)
    public void noEthanolConcInCTScans() {}

    @Test(expected = ConstraintViolationException.class)
    public void noScanUserInCTScans() {}

    @Test(expected = ConstraintViolationException.class)
    public void noAntScanInCTScans() {}

}
