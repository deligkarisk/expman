package com.arilab.expman.domain.validator;

import com.arilab.expman.domain.Species;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class SpeciesNamesValidator implements ConstraintValidator<SpeciesNames, Species> {


    @Override
    public void initialize(SpeciesNames constraintAnnotation) {

    }

    @Override
    public boolean isValid(Species species, ConstraintValidatorContext context) {
        if (species == null) {
            return false;
        }

        if ((species.getSpeciesName() == null) & (species.getSubspecies() == null) & (species.getMorphoCode() == null)) {
            return false;
        }
        return true;
    }
}
