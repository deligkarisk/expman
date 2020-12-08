package com.arilab.expman.bootstrap;

import com.arilab.expman.domain.app.Role;
import com.arilab.expman.domain.app.User;
import com.arilab.expman.repository.app.RoleRepository;
import com.arilab.expman.repository.app.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseLoader  implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private Map<String, User> users = new HashMap<>();

    public DatabaseLoader(RoleRepository roleRepository, UserRepository userRepository) {

        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }



    @Override
    public void run(String... args) {

   // addUsersAndRoles();

    }

    private void addUsersAndRoles() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");
        String secret2 = "{bcrypt}" + encoder.encode("otherpassword");


        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);

        User admin = new User("admin232323@gmail.com","admin",secret,true,"AdminFirstName","AdminLastName");
        admin.addRole(adminRole);
        admin.setConfirmPassword(secret);
        userRepository.save(admin);
        users.put("admin@gmail.com",admin);

        User user = new User("useremail22@gmail.com","user", secret2,true,"UserFirstName","UserLastName");
        user.addRole(userRole);
        user.setConfirmPassword(secret2);
        userRepository.save(user);







    }
}

