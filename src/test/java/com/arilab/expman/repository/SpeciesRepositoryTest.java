package com.arilab.expman.repository;

import com.arilab.expman.domain.Species;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpeciesRepositoryTest {

    @Value("${REFERENCE_SPECIES_TAXON_CODE}")
    private String REFERENCE_SPECIES_TAXON_CODE;

    @Value("${REFERENCE_GENUS}")
    private String REFERENCE_GENUS;

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


    @Test
    public void seniorSynonymSelfReferencingCanBeLoaded() {
       Optional<Species> speciesOptional = speciesRepository.findByTaxonCode(REFERENCE_SPECIES_TAXON_CODE);
       if (speciesOptional.isEmpty()) { fail("Could not run test. Taxon code not found"); }
       Species species = speciesOptional.get();
       assertNotNull(species.getSeniorSynonym());
    }
}
