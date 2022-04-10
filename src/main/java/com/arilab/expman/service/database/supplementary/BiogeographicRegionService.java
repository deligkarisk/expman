package com.arilab.expman.service.database.supplementary;

import com.arilab.expman.repository.database.supplementary.BiogeographicRegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiogeographicRegionService {

    BiogeographicRegionRepository biogeographicRegionRepository;

    public BiogeographicRegionService(BiogeographicRegionRepository biogeographicRegionRepository) {
        this.biogeographicRegionRepository = biogeographicRegionRepository;
    }

    public List<String> getMatchingBiogeographicRegions(String matchString) {
        return biogeographicRegionRepository.getMatchingBiogeographicRegions(matchString);
    }

}


