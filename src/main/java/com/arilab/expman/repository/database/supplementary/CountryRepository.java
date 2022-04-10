package com.arilab.expman.repository.database.supplementary;

import com.arilab.expman.domain.database.supplementary.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,String> {

    Optional<Country> findByCountryName(String country);

    @Query(value = "SELECT country_name FROM admin.country WHERE country_name LIKE %?1%",
            nativeQuery = true)
    public List<String> getMatchingCountries(String matchCode);
}
