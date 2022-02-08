package com.arilab.expman.repository;

import com.arilab.expman.domain.Subfamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubfamilyRepository extends JpaRepository<Subfamily, Integer> {

    Optional<Subfamily> findBySubfamily(String subfamily);

}
