package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Genus;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class GenusRepositoryTest {

    @Value("${REFERENCE_SUBFAMILY}")
    private String REFERENCE_SUBFAMILY;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SubfamilyRepository subfamilyRepository;

    @Autowired
    GenusRepository genusRepository;


    @Test
    public void genusRepositoryWorks() {
        Integer genuses = genusRepository.findAll().size();
        logger.info(String.format("Found %d genuses", genuses));
    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void newGenusCanBeAdded() {
        Genus genus = new Genus("TestGenusName");
        genus.setSubfamily(subfamilyRepository.findBySubfamily(REFERENCE_SUBFAMILY).get());
        genusRepository.saveAndFlush(genus);
    }
}
