package com.arilab.expman.converter;

import com.arilab.expman.domain.database.Species;
import org.springframework.core.convert.converter.Converter;

public class SpeciesToString implements Converter<Species, String> {

    @Override
    public String convert(Species species) {
        return species.toString();
    }
}
