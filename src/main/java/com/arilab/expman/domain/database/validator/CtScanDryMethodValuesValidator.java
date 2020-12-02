package com.arilab.expman.domain.database.validator;


import com.arilab.expman.domain.database.CtScan;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class CtScanDryMethodValuesValidator implements ConstraintValidator<CtScanDryMethodValues, CtScan> {

    @Override
    public void initialize(CtScanDryMethodValues constraintAnnotation) {

    }

    @Override
    public boolean isValid(CtScan ctscan, ConstraintValidatorContext context) {

        if (StringUtils.isNotEmpty(ctscan.getDryMethod())) {
            List<String> list = new ArrayList<String>();
            list.add("Pin");
            list.add("Amber");
            list.add("Resin");
            list.add("CPD");
            list.add("Freeze-dried");

            return(list.contains(ctscan.getDryMethod()));

        }
        return true;
    }
}
