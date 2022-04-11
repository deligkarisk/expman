package com.arilab.expman.service.database.supplementary;

import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import com.arilab.expman.repository.database.supplementary.BiogeographicRegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiogeographicRegionService {

    BiogeographicRegionRepository biogeographicRegionRepository;

    public BiogeographicRegionService(BiogeographicRegionRepository biogeographicRegionRepository) {
        this.biogeographicRegionRepository = biogeographicRegionRepository;
    }

    public List<String> getMatchingBiogeographicRegions(String matchString) {
        return biogeographicRegionRepository.getMatchingBiogeographicRegions(matchString);
    }

    public Optional<BiogeographicRegion> findById(String id) {
        return biogeographicRegionRepository.findById(id);
    }

}


