package com.arilab.expman.repository;

import com.arilab.expman.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        logger.info("Testing UserRepository");
        Optional<User> user = userRepository.findByUsername("admin");
        assertTrue(user.isPresent());

    }


}
