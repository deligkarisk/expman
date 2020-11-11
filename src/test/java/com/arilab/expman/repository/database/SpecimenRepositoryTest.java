package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Specimen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpecimenRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpecimenRepository specimenRepository;


    @Test
    public void repositoryWorks() {
        List<Specimen> specimens = specimenRepository.findAll();
        logger.info(String.format("Found %d specimens", specimens.size()));
    }

}
