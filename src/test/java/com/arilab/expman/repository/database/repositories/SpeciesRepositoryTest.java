package com.arilab.expman.repository.database.repositories;

import com.arilab.expman.domain.database.Species;
import com.arilab.expman.repository.database.GenusRepository;
import com.arilab.expman.repository.database.SpeciesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpeciesRepositoryTest {

    private final String REFERENCE_GENUS = "Adetomyrma";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    GenusRepository genusRepository;

    @Test
    public void speciesRepositoryWorks() {
        Integer species = speciesRepository.findAll().size();
        logger.info(String.format("Found %d species",species));
    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void newSpeciesCanBeAdded() {
        Species species = new Species(genusRepository.findByGenusName(REFERENCE_GENUS).get());
        species.setSpeciesName("TestSpecies");
        Species savedSpecies = speciesRepository.saveAndFlush(species);
        assertEquals(savedSpecies.getTaxonCode(), "Adetomyrma.TestSpecies");

    }
}
