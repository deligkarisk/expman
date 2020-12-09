package com.arilab.expman.controllers;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.service.database.SpecimenService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class DatabaseController {

    private SpecimenService specimenService;

    DatabaseController(SpecimenService specimenService) {
        this.specimenService = specimenService;
    }

    @GetMapping("/db/explore")
    public String returnExploreDb(Model model) {
        return specimensByPage(model, 1);
    }

    @GetMapping("/db/page/{pageNumber}")
    public String specimensByPage(Model model, @PathVariable("pageNumber") int currentPage) {

        Page<Specimen> specimenPage = specimenService.findAll(currentPage);
        int totalPages = specimenPage.getTotalPages();
        long totalSpecimens = specimenPage.getTotalElements();
        List<Specimen> specimens = specimenPage.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("specimens", specimens );
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalSpecimens", totalSpecimens);
        return "exploreDb";




    }

}
