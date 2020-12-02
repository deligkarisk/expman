package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.domain.database.Specimen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:test-references.properties"})
public class CtScanRepositoryTest {

    @Value("${REFERENCE_SPECIMEN_CODE}")
    private String REFERENCE_SPECIMEN_CODE;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CtScanRepository ctScanRepository;

    @Autowired
    SpecimenRepository specimenRepository;


    @Test
    public void ctScanRepositoryWorks() {
        Integer numberOfScans = ctScanRepository.findAll().size();
        logger.info(String.format("Found %d CT scans", numberOfScans));
    }

    @Transactional("arilabdbTransactionManager")
    @Test
    public void newCtScanCanBeAdded() {
        CtScan ctScan = new CtScan(specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get(),"70%", "Yes",
                                   "TestNewUser","No");
        ctScan.setCtScanNote("JUnitTest");
        ctScanRepository.saveAndFlush(ctScan);
    }


    // Failed conditions

    @Transactional("arilabdbTransactionManager")
    @Test(expected = ConstraintViolationException.class)
    public void noEthanolConcInCTScans() {
        Specimen specimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get();
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setScanUser("TestUser");
        ctScan.setAntscan("No");
        ctScan.setWet("Yes");
        try {
            ctScanRepository.save(ctScan);
        } catch (ConstraintViolationException cve) {
            assertTrue(cve.getConstraintViolations().size() == 1);
            throw cve;
        }
    }

    @Transactional("arilabdbTransactionManager")
    @Test(expected = ConstraintViolationException.class)
    public void noScanUserInCTScans() {
        Specimen specimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get();
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setAntscan("No");
        ctScan.setEthanolConcentration("70%");
        ctScan.setWet("Yes");
        try {
            ctScanRepository.saveAndFlush(ctScan);
        } catch (ConstraintViolationException cve) {
            assertTrue(cve.getConstraintViolations().size() == 1);
            throw cve;
        }
    }

    @Transactional("arilabdbTransactionManager")
    @Test(expected = ConstraintViolationException.class)
    public void noAntScanInCTScans() {
        Specimen specimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get();
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setEthanolConcentration("70%");
        ctScan.setScanUser("TestUser");
        ctScan.setWet("Yes");
        try {
            ctScanRepository.saveAndFlush(ctScan);
        } catch (ConstraintViolationException cve) {
            assertTrue(cve.getConstraintViolations().size() == 2);
            throw cve;
        }
    }

}
