package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen,Integer> {

    Optional<Specimen> findBySpecimenCode(String specimenCode);


}