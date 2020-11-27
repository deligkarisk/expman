package com.arilab.expman.repository.database.supplementary;

import com.arilab.expman.domain.database.supplementary.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {

    Optional<Country> findByCountryName(String country);
}
