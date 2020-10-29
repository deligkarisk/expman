package com.arilab.expman.domain.app.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueUserNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUserName {

    String message() default "{validation.username.unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
