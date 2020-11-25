package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.Specimen;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen,Integer> {

    @EntityGraph(value = "Specimen.FetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    Optional<Specimen> findBySpecimenCode(String specimenCode);

    @EntityGraph(value = "Specimen.FetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    List<Specimen> findAll();


}
