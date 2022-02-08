package com.arilab.expman.repository;

import com.arilab.expman.domain.CtScan;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtScanRepository extends JpaRepository<CtScan, Long> {

    @EntityGraph(value = "CtScan.Basic", type = EntityGraph.EntityGraphType.FETCH)
    List<CtScan> findAll();


}
