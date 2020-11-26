package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalityRepository extends JpaRepository<Locality, String> {

    Optional<Locality> findByLocalityCode(String localityCode);
}
