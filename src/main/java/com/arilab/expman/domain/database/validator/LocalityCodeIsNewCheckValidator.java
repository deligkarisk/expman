package com.arilab.expman.domain.database.validator;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.service.database.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class LocalityCodeIsNewCheckValidator implements
        ConstraintValidator<LocalityCodeIsNewCheck, String> {

    @Autowired
    LocalityService localityService;

    @Override
    public void initialize(LocalityCodeIsNewCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String localityCode, ConstraintValidatorContext context) {


        Optional<Locality> optionalLocality = localityService.findById(localityCode);
        if (optionalLocality.isPresent()) {
            return false;
        }

        return true;
    }

}
