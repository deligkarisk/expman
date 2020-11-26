package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.domain.database.Specimen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CtScanRepositoryTest {

    private final String REFERENCE_SPECIMEN_CODE = "CASENT0741232";

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


    // Failed conditions

    @Test(expected = ConstraintViolationException.class)
    public void noEthanolConcInCTScans() {
        Specimen specimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get();
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setAntscan("Yes");
        ctScan.setScanUser("TestUser");
        try {
            ctScanRepository.save(ctScan);
        } catch (ConstraintViolationException cve) {
            assertTrue(cve.getConstraintViolations().size() == 1); // Ensures that there is only one constraint
            // violation.
            throw cve;
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void noScanUserInCTScans() {
        Specimen specimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get();
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setAntscan("Yes");
        ctScan.setEthanolConcentration("70%");
        try {
            ctScanRepository.saveAndFlush(ctScan);
        } catch (ConstraintViolationException cve) {
            assertTrue(cve.getConstraintViolations().size() == 1); // Ensures that there is only one constraint
            // violation.
            throw cve;
        }
    }

   // @Transactional("arilabdbTransactionManager")
    @Test(expected = ConstraintViolationException.class)
    public void noAntScanInCTScans() {
        Specimen specimen = specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get();
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setEthanolConcentration("70%");
        ctScan.setScanUser("TestUser");
        try {
            ctScanRepository.saveAndFlush(ctScan);
        } catch (ConstraintViolationException cve) {
            assertTrue(cve.getConstraintViolations().size() == 1); // Ensures that there is only one constraint
            // violation.
            throw cve;
        }
    }

}
