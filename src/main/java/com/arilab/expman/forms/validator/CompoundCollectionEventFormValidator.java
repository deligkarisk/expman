package com.arilab.expman.forms.validator;

import com.arilab.expman.forms.CompoundCollectionEvent;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class CompoundCollectionEventFormValidator implements ConstraintValidator<CompoundCollectionEventForm,
        CompoundCollectionEvent> {

    @Override
    public boolean isValid(CompoundCollectionEvent compoundCollectionEvent, ConstraintValidatorContext context) {

        if ((compoundCollectionEvent.getLocality() != null) &&
        (compoundCollectionEvent.getCollectionEvent().getLocality() != null)) {
            return false;
        }

        return true;
    }

    @Override
    public void initialize(CompoundCollectionEventForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
