package com.arilab.expman.converter;

import com.arilab.expman.domain.database.Species;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StringToSpeciesTest {

    @Value("${REFERENCE_SPECIES_TAXON_CODE}")
    String REFERENCE_SPECIES_TAXON_CODE;

    @Value("${REFERENCE_SPECIES_TAXON_CODE_TYPE_LOCALITY}")
    String REFERENCE_SPECIES_TAXON_CODE_TYPE_LOCALITY;


    @Autowired
    StringToSpecies stringToSpecies;


    @Test(expected = IllegalArgumentException.class)
    public void testNull() throws Exception {
        stringToSpecies.convert(null);
    }

    @Test
    public void testEmptyString() {
        assertNull(stringToSpecies.convert(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTaxonCode() {
        stringToSpecies.convert("INVALIDTAXONCODE");
    }

    @Test
    public void testExistingTaxonCode() {
        Species species = stringToSpecies.convert(REFERENCE_SPECIES_TAXON_CODE);
        assertEquals(REFERENCE_SPECIES_TAXON_CODE_TYPE_LOCALITY, species.getTypeLocality());
    }
}
