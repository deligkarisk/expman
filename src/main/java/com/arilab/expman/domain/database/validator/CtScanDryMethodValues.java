package com.arilab.expman.domain.database.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = CtScanDryMethodValuesValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, ElementType.ANNOTATION_TYPE})
public @interface CtScanDryMethodValues {

    String message() default "{validation.ctscan.drymethodvalues}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

}
