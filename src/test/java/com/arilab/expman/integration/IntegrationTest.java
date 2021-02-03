package com.arilab.expman.integration;


import com.arilab.expman.domain.database.*;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.Country;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.repository.database.*;
import com.arilab.expman.repository.database.supplementary.BasisOfRecordRepository;
import com.arilab.expman.repository.database.supplementary.CountryRepository;
import com.arilab.expman.repository.database.supplementary.TypeStatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
//@TestPropertySource(locations = {"classpath:test-references.properties"})
//@Sql(scripts = "/dataArilabdb-tests.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class IntegrationTest {


    @Value("${REFERENCE_BASIS_OF_RECORD}")
    private String REFERENCE_BASIS_OF_RECORD;

    @Value("${REFERENCE_COLLECTION_EVENT_CODE}")
    private String REFERENCE_COLLECTION_EVENT_CODE;

    @Value("${REFERENCE_SPECIES_TAXON_CODE}")
    private String REFERENCE_SPECIES_TAXON_CODE;

    @Value("${REFERENCE_TYPE_STATUS}")
    private String REFERENCE_TYPE_STATUS;

    @Value("${REFERENCE_COUNTRY_NAME}")
    private String REFERENCE_COUNTRY_NAME;


    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LocalityRepository localityRepository;

    @Autowired
    BasisOfRecordRepository basisOfRecordRepository;

    @Autowired
    CollectionEventRepository collectionEventRepository;

    @Autowired
    GenusRepository genusRepository;

    @Autowired
    SpeciesRepository speciesRepository;

    @Autowired
    TypeStatusRepository typeStatusRepository;

    @Autowired
    SpecimenRepository specimenRepository;

    @Autowired
    CtScanRepository ctScanRepository;


    @Test
    @Transactional("arilabdbTransactionManager")
    public void newSpecimenCanBeAddedWithExistingSources() {
        BasisOfRecord basisOfRecord = basisOfRecordRepository.findByBasisOfRecord(REFERENCE_BASIS_OF_RECORD).get();
        CollectionEvent collectionEvent =
                collectionEventRepository.findByCollectionEventCode(REFERENCE_COLLECTION_EVENT_CODE).get();
        Species species = speciesRepository.findByTaxonCode(REFERENCE_SPECIES_TAXON_CODE).get();
        TypeStatus typeStatus = typeStatusRepository.findByTypeStatus(REFERENCE_TYPE_STATUS).get();

        Long numberOfSpecimensBefore = specimenRepository.count();

        Specimen specimen = new Specimen("TestSpecimenCode", typeStatus);
        specimen.setBasisOfRecord(basisOfRecord);
        specimen.setCollectionEvent(collectionEvent);
        specimen.setSpecies(species);
        specimenRepository.saveAndFlush(specimen);

        Long numberOfSpecimensAfter = specimenRepository.count();
        assertEquals(numberOfSpecimensAfter, numberOfSpecimensBefore + 1);

    }

    @Test
    @Transactional("arilabdbTransactionManager")
    public void newCtScanCanBeAddedNewSources() {

        long basisOfRecordCountBefore = basisOfRecordRepository.count();
        long countryCountBefore = countryRepository.count();
        long localityCountBefore = localityRepository.count();
        long collectionEventCountBefore = collectionEventRepository.count();
        long genusCountBefore = genusRepository.count();
        long speciesCountBefore = speciesRepository.count();
        long typeStatusCountBefore = typeStatusRepository.count();
        long specimenCountBefore = specimenRepository.count();
        long ctScanCountBefore = ctScanRepository.count();

        BasisOfRecord basisOfRecord = basisOfRecordRepository.findByBasisOfRecord(REFERENCE_BASIS_OF_RECORD).get();
        Country country = countryRepository.findByCountryName(REFERENCE_COUNTRY_NAME).get();
        Locality locality = new Locality("TestLocalityCode",country);
        localityRepository.save(locality);
        CollectionEvent collectionEvent = new CollectionEvent("TestCollectionEventCode", locality);
        collectionEventRepository.save(collectionEvent);
        Genus genus = new Genus("TestGenus");
        genusRepository.save(genus);
        Species species = new Species(genus);
        species.setSpeciesName("TestSpeciesName");
        speciesRepository.save(species);
        TypeStatus typeStatus = typeStatusRepository.findByTypeStatus(REFERENCE_TYPE_STATUS).get();
        Specimen specimen = new Specimen("TestSpecimenCode", typeStatus);
        specimen.setBasisOfRecord(basisOfRecord);
        specimen.setCollectionEvent(collectionEvent);
        specimen.setSpecies(species);
        specimenRepository.save(specimen);
        CtScan ctScan = new CtScan(specimen, "70%","Yes", "TestUser","No");
        ctScanRepository.save(ctScan);


        long basisOfRecordCountAfter = basisOfRecordRepository.count();
        long countryCountAfter = countryRepository.count();
        long localityCountAfter = localityRepository.count();
        long collectionEventCountAfter = collectionEventRepository.count();
        long genusCountAfter = genusRepository.count();
        long speciesCountAfter = speciesRepository.count();
        long typeStatusCountAfter = typeStatusRepository.count();
        long specimenCountAfter = specimenRepository.count();
        long ctScanCountAfter = ctScanRepository.count();

        // Assertions for tables with no new entries
        assertEquals(basisOfRecordCountBefore, basisOfRecordCountAfter);
        assertEquals(countryCountBefore, countryCountAfter);
        assertEquals(typeStatusCountBefore, typeStatusCountAfter);

        // Assertions for tables with one new entry
        assertEquals(localityCountAfter, localityCountBefore + 1);
        assertEquals(collectionEventCountAfter, collectionEventCountBefore + 1);
        assertEquals(genusCountAfter, genusCountBefore + 1);
        assertEquals(speciesCountAfter, speciesCountBefore + 1);
        assertEquals(specimenCountAfter, specimenCountBefore + 1);
        assertEquals(ctScanCountAfter, ctScanCountBefore + 1);
    }
}
