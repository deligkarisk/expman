package com.arilab.expman.repository;

import com.arilab.expman.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndActivationCode(String email, String activationCode);
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    Optional<User> findByUsername(String username);

}
