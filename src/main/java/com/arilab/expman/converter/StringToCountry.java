package com.arilab.expman.converter;

import com.arilab.expman.domain.database.supplementary.Country;
import com.arilab.expman.service.database.supplementary.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToCountry implements Converter<String, Country>  {


    @Autowired
    CountryService countryService;

    @Override
    public Country convert(String countryName) {


        if (countryName == null) {
            throw new IllegalArgumentException();
        }
        if (countryName.equals("")) {
            return null;
        }

        Optional<Country> optionalCountry =
                countryService.findByCountryName(countryName);
        if (optionalCountry.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalCountry.get();

    }

}
