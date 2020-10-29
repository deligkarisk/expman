package com.arilab.expman.service.app;


import com.arilab.expman.domain.app.User;
import com.arilab.expman.repository.app.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private MailService mailService;


    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {

        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mailService = mailService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        //Take the password from the form and encode it
        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);
        user.setConfirmPassword(secret);
        //user.addRole(roleService.findByName("ROLE_USER"));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setEnabled(false);
        save(user);
        sendActivationEmail(user);
        return user;
    }


    @Transactional(transactionManager = "expmanTransactionManager")
    public User save(User user) {
        return userRepository.save(user);
    }


    public void sendActivationEmail(User user) {
        mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user) {
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode) {
        return userRepository.findByEmailAndActivationCode(email, activationCode);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public Optional<User> findByEmailAndUsername(String email, String username) {
        return userRepository.findByEmailAndUsername(email, username);

    }

    @Transactional(transactionManager = "expmanTransactionManager")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}