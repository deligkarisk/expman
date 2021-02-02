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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.validation.ConstraintViolationException;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class CtScanRepositoryTest {

    @Value("${REFERENCE_SPECIMEN_CODE}")
    private String REFERENCE_SPECIMEN_CODE;

    @Value("${REFERENCE_CTSCAN_CODE}")
    private int REFERENCE_CTSCAN_CODE;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();

    @Autowired
    CtScanRepository ctScanRepository;

    @Autowired
    SpecimenRepository specimenRepository;


    @Test
    @Transactional("arilabdbTransactionManager")
    public void ctScanRepositoryWorks() {
        Integer numberOfScans = ctScanRepository.findAll().size();
        logger.info(String.format("Found %d CT scans", numberOfScans));
    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void FetchPlanInFindAll() {
        List<CtScan> allCtScans = ctScanRepository.findAll();
        logger.debug("Finished fetching all ct scans, continuing with getting one item from list");
        CtScan ctScan = allCtScans.get(0);
        assertTrue(persistenceUtil.isLoaded(ctScan, "specimen"));
        assertTrue(persistenceUtil.isLoaded(ctScan.getSpecimen(), "collectionEvent"));
        assertTrue(persistenceUtil.isLoaded(ctScan.getSpecimen().getCollectionEvent(), "locality"));
        assertFalse(persistenceUtil.isLoaded(ctScan.getSpecimen(), "typeStatus"));
        assertFalse(persistenceUtil.isLoaded(ctScan.getSpecimen(), "basisOfRecord"));
        assertFalse(persistenceUtil.isLoaded(ctScan.getSpecimen(), "species"));
        logger.debug("Finished checking the default initialization of objects, continuing with reading properties of " +
                             "the specimen.");


        // Reading the id of a lazy entity does not initialize the object
        String speciesId = ctScan.getSpecimen().getSpecies().getTaxonCode();
        assertFalse(persistenceUtil.isLoaded(ctScan.getSpecimen(), "species"));

        // Reading another field initializes the object
        String speciesName = ctScan.getSpecimen().getSpecies().getSpeciesName();
        assertTrue(persistenceUtil.isLoaded(ctScan.getSpecimen(), "species"));
    }

    @Transactional("arilabdbTransactionManager")
    @Test
    public void newCtScanCanBeAdded() {
        CtScan ctScan = new CtScan(specimenRepository.findBySpecimenCode(REFERENCE_SPECIMEN_CODE).get(), "70%", "Yes",
                                   "TestNewUser", "No");
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
            assertEquals(1, cve.getConstraintViolations().size());
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
            assertEquals(1, cve.getConstraintViolations().size());
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
            assertEquals(2, cve.getConstraintViolations().size());
            throw cve;
        }
    }


}
