package com.arilab.expman.service.database.supplementary;

import com.arilab.expman.domain.database.supplementary.Country;
import com.arilab.expman.repository.database.supplementary.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<String> getMatchingCountries(String matchCode) {
        return countryRepository.getMatchingCountries(matchCode);
    }

    public Optional<Country> findByCountryName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }
}
