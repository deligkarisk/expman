package com.arilab.expman.domain.database.validator;

import com.arilab.expman.domain.app.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = SpeciesNamesValidator.class)
@Target({TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpeciesNames {

    String message() default "{validation.species.names}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}

