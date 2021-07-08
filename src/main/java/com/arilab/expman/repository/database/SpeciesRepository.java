package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, String> {

    Optional<Species> findByTaxonCode(String taxonCode);

    @Query(value = "SELECT taxon_code FROM species WHERE taxon_code LIKE %?1%",
           nativeQuery = true)
    public List<String> getMatchingSpecies(String matchingSpecies);


}
