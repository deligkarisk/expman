package com.arilab.expman.repository;

import com.arilab.expman.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    // Need to remove the transactional propagation property, otherwise the unique email and username validators
    // result in  StackOverflow exception.
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Optional<User> findByEmail(String email);

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Optional<User> findByUsername(String username);


    Optional<User> findByEmailAndActivationCode(String email, String activationCode);

    // This is used in the integration tests and needs to support transactions.
    Optional<User> findByEmailAndUsername(String email, String userName);


    List<User> findAll();

}
