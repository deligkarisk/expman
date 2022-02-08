package com.arilab.expman.domain.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = SpeciesNamesValidator.class)
@Target({TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpeciesNames {

    String message() default "{validation.species.names}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}

