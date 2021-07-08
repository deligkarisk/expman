package com.arilab.expman.converter;

import com.arilab.expman.domain.database.Species;
import com.arilab.expman.service.database.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToSpecies implements Converter<String, Species> {

    @Autowired
    SpeciesService speciesService;


    @Override
    public Species convert(String taxonCode) {

        if (taxonCode == null) {throw new IllegalArgumentException();}
        if (taxonCode.equals("")) {return null;}

        Optional<Species> optionalSpecies = speciesService.findByTaxonCode(taxonCode);
        if (optionalSpecies.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalSpecies.get();
    }
}
