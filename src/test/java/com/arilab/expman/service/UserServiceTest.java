package com.arilab.expman.service;

import com.arilab.expman.domain.app.User;
import com.arilab.expman.service.app.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    // New users can be added through the service
    @Test
    @Transactional("expmanTransactionManager")
    public void userCanBeAdded() {
        User testUser = new User("testuser@email.com","testusername", "samplepass", false, "firstname", "lastname");
        assertTrue(userService.register(testUser).getClass() == User.class);
        Optional<User> user =  userService.findByEmailAndUsername("testuser@email.com", "testusername");
        assertTrue(user.isPresent());
    }

    //

}
