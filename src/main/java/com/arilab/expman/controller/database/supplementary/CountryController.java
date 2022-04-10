package com.arilab.expman.controller.database.supplementary;

import com.arilab.expman.service.database.supplementary.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CountryController {

    CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("/countryAutocomplete")
    @ResponseBody
    public List<String> countryAutocomplete(@RequestParam (value="term", required = false, defaultValue = "") String term) {
        List<String> suggestions = countryService.getMatchingCountries(term);
        return suggestions;
    }
}
