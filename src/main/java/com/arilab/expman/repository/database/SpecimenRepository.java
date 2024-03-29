package com.arilab.expman.repository.database;


import com.arilab.expman.domain.database.Specimen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen,String> {

    @EntityGraph(value = "Specimen.GlobalFetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    Optional<Specimen> findBySpecimenCode(String specimenCode);


    @EntityGraph(value = "Specimen.GlobalFetchAll" , type = EntityGraph.EntityGraphType.FETCH)
    Optional<Specimen> findSingleSpecimenBySpecimenCode(String specimenCode);


    @EntityGraph(value = "Specimen.GlobalFetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    List<Specimen> findAll();

    @EntityGraph(value = "Specimen.GlobalFetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    Page<Specimen> findAll(Pageable pageable);



    @EntityGraph(value = "Specimen.GlobalFetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    List<Specimen> findBySpecimenCodeContainingIgnoreCase(String specimenCode);


    @EntityGraph(value = "Specimen.GlobalFetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    List<Specimen> findByCollectionEvent_Locality_LocalityCodeContainingIgnoreCase(String localityCode); // this is how we can search
    // parent objects for child objects' values. See also https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions


    @EntityGraph(value = "Specimen.GlobalFetchBasic", type= EntityGraph.EntityGraphType.FETCH)
    List<Specimen> findBySpecies_TaxonCodeContainingIgnoreCase(String taxonCode); // this is how we can search
    // parent objects for child objects' values. See also https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-property-expressions



}
