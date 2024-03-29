package com.arilab.expman.forms.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = CompoundCollectionEventLocalityValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, ElementType.ANNOTATION_TYPE})
public @interface CompoundCollectionEventLocality {

    String message() default "{validation.forms.compound_collection_event.locality}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
