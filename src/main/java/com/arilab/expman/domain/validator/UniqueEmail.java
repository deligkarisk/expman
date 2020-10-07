package com.arilab.expman.domain.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default "Email not unique. Perhaps you have already registered with this email.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
