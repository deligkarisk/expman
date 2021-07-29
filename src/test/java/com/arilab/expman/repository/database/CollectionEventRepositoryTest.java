package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Locality;
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

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectionEventRepositoryTest {

    @Value("${REFERENCE_LOCALITY}")
    private String REFERENCE_LOCALITY;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CollectionEventRepository collectionEventRepository;

    @Autowired
    LocalityRepository localityRepository;

    @Test
    public void collectionEventRepositoryWorks() {
        Integer collectionEvents = collectionEventRepository.findAll().size();
        logger.info(String.format("Found %d collection events", collectionEvents));
    }

    @Transactional("arilabdbTransactionManager")
    @Test
    public void collectionEventCanBeAdded() {
        Locality locality = localityRepository.findByLocalityCode(REFERENCE_LOCALITY).get();
        CollectionEvent collectionEvent = new CollectionEvent("TestCollCode");
        collectionEvent.setLocality(locality);
        collectionEventRepository.saveAndFlush(collectionEvent);
    }


    // Failed conditions
    @Transactional("arilabdbTransactionManager")
    @Test(expected = javax.validation.ConstraintViolationException.class)
    public void noLocalityInCollectionEvent() {
        CollectionEvent collectionEvent = new CollectionEvent();
        collectionEvent.setCollectionEventCode("TestCode");
        try {
            collectionEventRepository.saveAndFlush(collectionEvent);
        } catch (ConstraintViolationException cve) {
            assertEquals(cve.getConstraintViolations().size(), 1); // Ensures that there is only one constraint
            // violation.
            throw cve;
        }

    }
}
