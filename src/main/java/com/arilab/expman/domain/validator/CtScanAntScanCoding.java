package com.arilab.expman.domain.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = CtScanAntScanCodingValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, ElementType.ANNOTATION_TYPE})
public @interface CtScanAntScanCoding {


    String message() default "{validation.ctscan.antscancoding}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

}
