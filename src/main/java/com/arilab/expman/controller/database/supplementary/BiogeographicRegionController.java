package com.arilab.expman.controller.database.supplementary;

import com.arilab.expman.service.database.supplementary.BiogeographicRegionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BiogeographicRegionController {


    BiogeographicRegionService biogeographicRegionService;

    public BiogeographicRegionController(BiogeographicRegionService biogeographicRegionService) {
        this.biogeographicRegionService = biogeographicRegionService;
    }

    @RequestMapping("/biogeographicRegionAutocomplete")
    @ResponseBody
    public List<String> biogeographicRegionAutocomplete(@RequestParam (value = "term", required = false,
            defaultValue = "") String term) {
        return biogeographicRegionService.getMatchingBiogeographicRegions(term);
    }

}
