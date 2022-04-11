package com.arilab.expman.converter;

import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import com.arilab.expman.service.database.supplementary.BiogeographicRegionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToBiogeographicRegion implements Converter<String, BiogeographicRegion> {

    BiogeographicRegionService biogeographicRegionService;

    public StringToBiogeographicRegion(BiogeographicRegionService biogeographicRegionService) {
        this.biogeographicRegionService = biogeographicRegionService;
    }

    @Override
    public BiogeographicRegion convert(String biogeographicRegion) {

        if (biogeographicRegion == null) {throw new IllegalArgumentException();}
        if (biogeographicRegion.equals("")) {return null;}

        Optional<BiogeographicRegion> optionalBiogeographicRegion = biogeographicRegionService.findById(biogeographicRegion);
        if (optionalBiogeographicRegion.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalBiogeographicRegion.get();
    }
}
