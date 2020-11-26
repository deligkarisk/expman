package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, String> {

    Optional<Species> findByTaxonCode(String taxonCode);

}
