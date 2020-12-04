package com.arilab.expman.domain.database.validator;

import com.arilab.expman.domain.database.CtScan;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CtScanDryWetFieldsValidator implements ConstraintValidator<CtScanDryWetFields, CtScan> {

    @Override
    public void initialize(CtScanDryWetFields constraintAnnotation) {

    }

    @Override
    public boolean isValid(CtScan ctscan, ConstraintValidatorContext context) {

        if (ctscan.getWet() == null) {
            return false;
        }

        if (!(ctscan.getWet().equals("Yes") || (ctscan.getWet().equals("No")))) {
            return false;
        }

        if (ctscan.getWet().equals("Yes") && ctscan.getDryMethod() != null ) {
            return false;
        }

        if (ctscan.getWet().equals("No") && ctscan.getDryMethod() == null) {
            return false;
        }

        return true;

    }
}
