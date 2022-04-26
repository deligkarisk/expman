package com.arilab.expman.converter;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.service.database.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class StringToLocality implements Converter<String, Locality> {


    @Autowired
    LocalityService localityService;

    @Override
    public Locality convert(String localityCode) {
        if (localityCode == null) {
            throw new IllegalArgumentException("Locality code should not be null in converter.");
        }

        if (localityCode.equals("")) { return null; }

        Optional<Locality> optionalLocality = localityService.findById(localityCode);
        if (optionalLocality.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalLocality.get();
    }
}
