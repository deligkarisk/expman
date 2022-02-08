package com.arilab.expman.repository;

import com.arilab.expman.domain.Genus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenusRepository extends JpaRepository<Genus,Integer> {

    Optional<Genus> findByGenusName(String genusName);


}
