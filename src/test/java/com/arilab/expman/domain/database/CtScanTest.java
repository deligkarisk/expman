package com.arilab.expman.domain.database;

import com.arilab.expman.domain.database.enums.DryMethod;
import com.arilab.expman.domain.database.enums.Model;
import com.arilab.expman.domain.database.validator.OnInsert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CtScanTest {

    @MockBean
    Specimen specimen;

    @Qualifier("localValidatorFactoryBean")
    @Autowired
    Validator validator;

    @Test
    public void validFieldsWetOnAntscan() {
        CtScan ctScan = new CtScan(specimen, "99%", "Yes", "TestUser", "Yes");
        ctScan.setAntscanCode("SomeCode");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(0, violations.size());
    }

    @Test
    public void validFieldsDryOnAntscan() {
        CtScan ctScan = new CtScan(specimen, "99%", "No", "TestUser", "Yes");
        ctScan.setAntscanCode("SomeCode");
        ctScan.setDryMethod(DryMethod.Pin);
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(0, violations.size());
    }


    @Test
    public void validFieldsWetNotOnAntscan() {
        CtScan ctScan = new CtScan(specimen, "99%", "Yes", "TestUser", "No");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(0, violations.size());
    }


    @Test
    public void validFieldsDryNotOnAntscan() {
        CtScan ctScan = new CtScan(specimen, "99%", "No", "TestUser", "No");
        ctScan.setDryMethod(DryMethod.Pin);
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(0, violations.size());
    }


    @Test
    public void antScanWithNullCode() {
        CtScan ctScan = new CtScan(specimen, "99%","Yes", "TestUser", "Yes");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(violations.size(),1);
        assertEquals("{validation.ctscan.antscancoding}", violations.iterator().next().getMessageTemplate());

        ctScan.setAntscanCode("NotEmpty");
        assertEquals(0, validator.validate(ctScan, OnInsert.class).size());
    }


    @Test
    public void antScanWithEmptyCode() {
        CtScan ctScan = new CtScan(specimen, "99%","Yes", "TestUser", "Yes");
        ctScan.setAntscanCode("");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(violations.size(),1);
        assertEquals("{validation.ctscan.antscancoding}", violations.iterator().next().getMessageTemplate());

        ctScan.setAntscanCode("NotEmpty");
        assertEquals(0, validator.validate(ctScan, OnInsert.class).size());

    }


    @Test
    public void notAntScanWithCode() {
        CtScan ctScan = new CtScan(specimen, "99%","Yes", "TestUser", "No");
        ctScan.setAntscanCode("TestCode");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(violations.size(),1);
        assertEquals("{validation.ctscan.antscancoding}", violations.iterator().next().getMessageTemplate());

    }


    @Test
    public void AntscanNotYesOrNo() {
        CtScan ctScan = new CtScan(specimen, "99%","Yes", "TestUser", "Something");
        ctScan.setAntscanCode("");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(1, violations.size());
        assertEquals("{validation.ctscan.antscancoding}", violations.iterator().next().getMessageTemplate());

    }


    @Test
    public void nullAntScanField() {
        CtScan ctScan = new CtScan();
        ctScan.setSpecimen(specimen);
        ctScan.setEthanolConcentration("99%");
        ctScan.setWet("Yes");
        ctScan.setScanUser("TestUser");
        ctScan.setAntscanCode("");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(2, violations.size()); // Two exceptions will be risen, one from the @NotEmpty annotation, one
        // from the custom validator.

        ctScan.setAntscan("No");
        assertEquals(0, validator.validate(ctScan, OnInsert.class).size());
    }


    @Test
    public void wetWithDryMethod() {
        CtScan ctScan = new CtScan(specimen, "99%","Yes", "TestUser", "No");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(0, violations.size()); // Dry method not set yet, so this should be valid

        ctScan.setDryMethod(DryMethod.Pin);
        Set<ConstraintViolation<CtScan>> violationsPost = validator.validate(ctScan, OnInsert.class);
        assertEquals(1, violationsPost.size());
        assertEquals("{validation.ctscan.drywet}", violationsPost.iterator().next().getMessageTemplate());
    }


    @Test
    public void dryWithoutDryMethod() {
        CtScan ctScan = new CtScan(specimen, "99%","No", "TestUser", "No");
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(1, violations.size());
        assertEquals("{validation.ctscan.drywet}", violations.iterator().next().getMessageTemplate());

        ctScan.setDryMethod(DryMethod.Pin);
        assertEquals(0, validator.validate(ctScan, OnInsert.class).size());
    }


    @Test
    public void correctModelEnum() {
        CtScan ctScan = new CtScan(specimen, "99%", "Yes", "TestUser", "No");
        ctScan.setModel(Model.Ants);
        Set<ConstraintViolation<CtScan>> violations = validator.validate(ctScan, OnInsert.class);
        assertEquals(0, violations.size());
    }



}
