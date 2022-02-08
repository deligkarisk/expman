package com.arilab.expman.service;

import com.arilab.expman.domain.Species;
import com.arilab.expman.repository.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    private SpeciesRepository speciesRepository;

    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public List<Species> findAll() {
        return speciesRepository.findAll();
    }

    public Optional<Species> findByTaxonCode(String taxonCode) {
        return speciesRepository.findByTaxonCode(taxonCode);
    }

    public List<String> getMatchingTaxonCodes(String matchingSpecies) {
        return speciesRepository.getMatchingSpecies(matchingSpecies);
    }
}
