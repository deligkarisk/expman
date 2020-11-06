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
public class GenusRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    GenusRepository genusRepository;


    @Test
    public void genusRepositoryWorks() {
        Integer genuses = genusRepository.findAll().size();
        logger.info(String.format("Found %d genuses", genuses));
    }
}
