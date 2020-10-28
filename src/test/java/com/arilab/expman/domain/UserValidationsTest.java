package com.arilab.expman.domain;

import com.arilab.expman.domain.validator.OnInsert;
import com.arilab.expman.domain.validator.PasswordsMatchValidator;
import com.arilab.expman.repository.UserRepository;
import com.arilab.expman.service.app.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.postgresql.gss.GSSOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserValidationsTest {

    @Qualifier("localValidatorFactoryBean")
    @Autowired
    private Validator validator;

    @Autowired
    UserService userService;


    @Test
    public void paswordsDoNotMatchTest() {
        User user = new User("testemail", "testusername", "pass", true, "fname", "lname");
        user.setConfirmPassword("confirmpass");
        Set<ConstraintViolation<User>> constrainsViolations = validator.validate(user);
        assertEquals(1, constrainsViolations.size());
        assertEquals(constrainsViolations.iterator().next().getMessageTemplate(), "{validation.passwords.donotmatch}");
    }

    @Test
    public void passwordsMatchTest() {
        User user = new User("testemail", "testusername", "pass", true, "fname", "lname");
        user.setConfirmPassword("pass");
        Set<ConstraintViolation<User>> constrainsViolations = validator.validate(user);
        assertEquals(0, constrainsViolations.size());
    }


    // For the below validator we get the first user, and copy its username to a new entity, which gets subsequently
    // validated.
    @Test
    @Transactional
    public void userNameNotUnique() {
        User existingUser = userService.findAll().iterator().next();
        User user = new User("testemail1", existingUser.getUsername(), "pass", true, "fname", "lname");
        user.setConfirmPassword("pass");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user, OnInsert.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(constraintViolations.iterator().next().getMessageTemplate(), "{validation.username.unique}");
    }

    @Test
    @Transactional
    public void EmailNotUnique() {
        User existingUser = userService.findAll().iterator().next();
        User user = new User(existingUser.getEmail(), "randomusername", "pass", true, "fname", "lname");
        user.setConfirmPassword("pass");
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user, OnInsert.class);
        assertEquals(1, constraintViolations.size());
        assertEquals(constraintViolations.iterator().next().getMessageTemplate(), "{validation.email.unique}");
    }

}
