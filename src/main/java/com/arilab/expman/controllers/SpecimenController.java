package com.arilab.expman.controllers;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.service.database.SpecimenService;
import com.arilab.expman.service.database.supplementary.BasisOfRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
public class SpecimenController {

    private SpecimenService specimenService;

    @Autowired
    private BasisOfRecordService basisOfRecordService;

    SpecimenController(SpecimenService specimenService) {
        this.specimenService = specimenService;
    }

    @GetMapping("/explore/specimens")
    public String exploreSpecimens(Model model) {
        return exploreSpecimensByPage(model, 1);
    }

    @GetMapping("/explore/specimens/page/{pageNumber}")
    public String exploreSpecimensByPage(Model model, @PathVariable("pageNumber") int currentPage) {

        Page<Specimen> specimenPage = specimenService.findAll(currentPage);
        int totalPages = specimenPage.getTotalPages();
        long totalSpecimens = specimenPage.getTotalElements();
        List<Specimen> specimens = specimenPage.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("specimens", specimens );
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalSpecimens", totalSpecimens);
        return "layouts/explore/specimens";
    }

    @GetMapping("/edit/specimen/{specimenCode}")
    public String editSpecimen(Model model, @PathVariable("specimenCode") String specimenCode) {
        Optional<Specimen> optionalSpecimen = specimenService.findSingleSpecimenBySpecimenCode(specimenCode);

        if (optionalSpecimen.isEmpty()) {
            return "/layouts/edit/does_not_exist";
        }

        Specimen specimen = optionalSpecimen.get();
        List<BasisOfRecord> basisOfRecords = basisOfRecordService.findAll();
        model.addAttribute("basisOfRecords",basisOfRecords);
        model.addAttribute("specimen", specimen);
        return("layouts/edit/specimen");

    }


    @PostMapping("/edit/specimen")
    public String updateSpecimen(@Validated Specimen specimen, BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("specimen", specimen);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "/layouts/edit/specimen";
        } else {
            Specimen newSpecimen = specimen;
            System.out.println("OK");
        }
        return "layouts/edit/specimen";
    }

}
