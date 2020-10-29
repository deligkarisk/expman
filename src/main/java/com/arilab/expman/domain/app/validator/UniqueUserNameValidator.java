package com.arilab.expman.domain.app.validator;

import com.arilab.expman.service.app.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component("beforeSaveUniqueUserNameValidator")
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    private  UserService userService;


    @Override
    public void initialize(UniqueUserName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Running Username validator");
       return userService.findByUsername(username).isEmpty();

    }
}
