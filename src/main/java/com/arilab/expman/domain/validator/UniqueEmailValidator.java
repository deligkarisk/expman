package com.arilab.expman.domain.validator;

import com.arilab.expman.domain.User;
import com.arilab.expman.service.app.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component("beforeSaveUniqueEmailValidator")
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {


    @Autowired
    private UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return userService.findByEmail(email).isEmpty();
    }
}
