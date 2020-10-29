package com.arilab.expman.domain.app.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {

    String message() default "{validation.email.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
