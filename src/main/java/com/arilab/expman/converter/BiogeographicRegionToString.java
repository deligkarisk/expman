package com.arilab.expman.converter;

import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import org.springframework.core.convert.converter.Converter;

public class BiogeographicRegionToString implements Converter<BiogeographicRegion, String> {
    @Override
    public String convert(BiogeographicRegion biogeographicRegion) {
        return biogeographicRegion.toString();
    }
}
