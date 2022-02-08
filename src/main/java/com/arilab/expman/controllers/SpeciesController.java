package com.arilab.expman.controllers;

import com.arilab.expman.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpeciesController {

    @Autowired
    SpeciesService speciesService;


    @ResponseBody
    public List<String> speciesAutocomplete(@RequestParam(value="term", required = false, defaultValue = "") String term) {
        return speciesService.getMatchingTaxonCodes(term);
    }


}
