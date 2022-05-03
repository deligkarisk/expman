package com.arilab.expman.dto.validator;

import com.arilab.expman.service.database.supplementary.BiogeographicRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class BioGeoRegionExistsOrIsNullValidator implements ConstraintValidator<BioGeoRegionExistsOrIsNull, String> {

    @Autowired
    BiogeographicRegionService biogeographicRegionService;

    @Override
    public void initialize(BioGeoRegionExistsOrIsNull constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) { return true;}
        return (biogeographicRegionService.findById(value).isPresent());
    }
}
