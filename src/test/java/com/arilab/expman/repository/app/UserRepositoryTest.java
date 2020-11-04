package com.arilab.expman.repository.app;

import com.arilab.expman.domain.app.User;
import com.arilab.expman.repository.app.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    UserRepository userRepository;


    // An admin user is present
    @Test
    public void contextLoads() {
        logger.info("Testing UserRepository");
        Optional<User> user = userRepository.findByUsername("admin");
        assertTrue(user.isPresent());
    }




}
