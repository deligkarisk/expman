package com.arilab.expman.repository.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectionEventRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CollectionEventRepository collectionEventRepository;

    @Test
    public void collectionEventRepositoryWorks() {
        Integer collectionEvents = collectionEventRepository.findAll().size();
        logger.info(String.format("Found %d collection events", collectionEvents));
    }
}