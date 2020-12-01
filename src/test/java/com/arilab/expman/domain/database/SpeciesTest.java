package com.arilab.expman.domain.database;

import com.arilab.expman.domain.database.validator.OnInsert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpeciesTest {

    @MockBean
    Genus genus;

    @Qualifier("localValidatorFactoryBean")
    @Autowired
    Validator validator;

    private Logger logger = LoggerFactory.getLogger(SpeciesTest.class);

    @Test
    public void speciesNamesAllMissing() {
        Species species = new Species(genus);
        Set<ConstraintViolation<Species>> violations = validator.validate(species, OnInsert.class);
        assertEquals(violations.size(), 1);
        assertEquals(violations.iterator().next().getMessageTemplate(), "{validation.species.names}");

        // The default group validation should give no errors
        Set<ConstraintViolation<Species>> violationsDefault = validator.validate(species);
        assertEquals(violationsDefault.size(), 0);
    }

    @Test
    public void speciesNamesExists() {
        Species species = new Species(genus);
        species.setSpeciesName("TestSpecies");
        Set<ConstraintViolation<Species>> violations = validator.validate(species, OnInsert.class);
        Set<ConstraintViolation<Species>> violationsDefault = validator.validate(species);
        assertEquals(violations.size(), 0);
        assertEquals(violationsDefault.size(), 0);
    }

    @Test
    public void subspeciesNameExists() {
        Species species = new Species(genus);
        species.setSubspecies("TestSubspiecies");
        Set<ConstraintViolation<Species>> violations = validator.validate(species, OnInsert.class);
        Set<ConstraintViolation<Species>> violationsDefault = validator.validate(species);
        assertEquals(violations.size(), 0);
        assertEquals(violationsDefault.size(), 0);
    }


    @Test
    public void morphoCodeExists() {
        Species species = new Species(genus);
        species.setMorphoCode("TestMorphoCode");
        Set<ConstraintViolation<Species>> violations = validator.validate(species,OnInsert.class);
        Set<ConstraintViolation<Species>> violationsDefault = validator.validate(species);
        assertEquals(violations.size(),0);
        assertEquals(violationsDefault.size(),0);
    }
}