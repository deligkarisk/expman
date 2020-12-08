package com.arilab.expman.controllers;

import com.arilab.expman.service.database.SpecimenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DatabaseController {

    private SpecimenService specimenService;

    DatabaseController(SpecimenService specimenService) {
        this.specimenService = specimenService;
    }

    @GetMapping("/db/explore")
    public String returnExploreDb(Model model) {
        model.addAttribute("specimens", specimenService.findAll());
        return "exploreDb";
    }

}
