package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Specimen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpecimenRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpecimenRepository specimenRepository;


    @Test
    public void repositoryWorks() {
        Optional<Specimen> specimen = specimenRepository.findBySpecimenId(4405);
        logger.info("Entry loaded");
        List<Specimen> specimens = specimenRepository.findAll();
        logger.info("Entries loaded");
    }

    // Failed conditions
    @Test(expected = ConstraintViolationException.class)
    public void noTypeStatusInSpecimen() {}


}
