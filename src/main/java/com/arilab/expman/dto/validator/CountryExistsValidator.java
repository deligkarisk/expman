package com.arilab.expman.dto.validator;

import com.arilab.expman.service.database.supplementary.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CountryExistsValidator implements ConstraintValidator<CountryExists, String> {

    @Autowired
    CountryService countryService;

    @Override
    public void initialize(CountryExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return countryService.findByCountryName(value).isPresent();
    }
}
