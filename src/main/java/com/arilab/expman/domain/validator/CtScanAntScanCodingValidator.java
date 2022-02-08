package com.arilab.expman.domain.validator;

import com.arilab.expman.domain.CtScan;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

@Component
public class CtScanAntScanCodingValidator implements ConstraintValidator<CtScanAntScanCoding, CtScan> {

    @Override
    public void initialize(CtScanAntScanCoding constraintAnnotation) {

    }

    @Override
    public boolean isValid(CtScan ctscan, ConstraintValidatorContext context) {

        if ((ctscan.getAntscan() == null)) {
            return false;
        }

        if (!ctscan.getAntscan().equals("No") && !ctscan.getAntscan().equals("Yes")) {
            return false;
        }

        if (ctscan.getAntscan().equals("No") && StringUtils.isNotEmpty(ctscan.getAntscanCode())) {
            return false;
        }

        if (ctscan.getAntscan().equals("Yes") && StringUtils.isEmpty(ctscan.getAntscanCode())) {
            return false;
        }

        return true;

    }
}
