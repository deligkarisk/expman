package com.arilab.expman.controllers;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.service.database.SpecimenService;
import com.arilab.expman.service.database.supplementary.BasisOfRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class SpecimenController {

    private SpecimenService specimenService;

    @Autowired
    private BasisOfRecordService basisOfRecordService;


    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

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


    @GetMapping("/view/specimen/{specimenCode}")
    public String viewSpecimen(Model model, @PathVariable("specimenCode") String specimenCode) {
        Optional<Specimen> optionalSpecimen = specimenService.findSingleSpecimenBySpecimenCode(specimenCode);

        if (optionalSpecimen.isEmpty()) {
            return "/layouts/view/view_specimen_does_not_exist";
        }

        Specimen specimen = optionalSpecimen.get();
        model.addAttribute("specimen", specimen);
        return("layouts/view/specimen");

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
    public String updateSpecimen(@ModelAttribute("specimen") @Validated Specimen specimen, BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            List<BasisOfRecord> basisOfRecords = basisOfRecordService.findAll();

            model.addAttribute("specimen", specimen);
            model.addAttribute("basisOfRecords",basisOfRecords);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "layouts/edit/specimen";
        } else {
            Specimen savedSpecimen = specimenService.saveSpecimen(specimen);
            System.out.println("OK");
            return "redirect:/view/specimen/" + savedSpecimen.getSpecimenCode();
        }

    }

}
