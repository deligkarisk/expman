package com.arilab.expman.controllers;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.service.database.SpecimenService;
import com.arilab.expman.service.database.supplementary.BasisOfRecordService;
import com.arilab.expman.service.database.supplementary.TypeStatusService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class SpecimenController {

    private SpecimenService specimenService;
    private BasisOfRecordService basisOfRecordService;
    private TypeStatusService typeStatusService;

    SpecimenController(SpecimenService specimenService, BasisOfRecordService basisOfRecordService,
                       TypeStatusService typeStatusService) {
        this.specimenService = specimenService;
        this.basisOfRecordService = basisOfRecordService;
        this.typeStatusService = typeStatusService;
    }

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @ModelAttribute("basisOfRecords")
    public List<BasisOfRecord> basisOfRecords() {
        List<BasisOfRecord> basisOfRecords = basisOfRecordService.findAll();
        return basisOfRecords;
    }

    @ModelAttribute("typeStatus")
    public List<TypeStatus> typeStatuses() {
        List<TypeStatus> typeStatuses = typeStatusService.findAll();
        return typeStatuses;
    }

    @ModelAttribute("specimen")
    public Specimen ctScanModel(@PathVariable(value = "specimenCode", required = false) String specimenCode) {
        if (specimenCode == null) {
            return null;
        }
        Optional<Specimen> specimen = specimenService.findSingleSpecimenBySpecimenCode(specimenCode);
        return specimen.orElse(null);
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
        model.addAttribute("specimens", specimens);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalSpecimens", totalSpecimens);
        return "layouts/explore/specimens";
    }


    @GetMapping("/view/specimen/{specimenCode}")
    public String viewSpecimen(Model model, @PathVariable("specimenCode") String specimenCode) {
        if (model.getAttribute("specimen") == null) {
            return("/layouts/view/does_not_exist/generic_does_not_exist");
        }

        return ("layouts/view/specimen");
    }

    @GetMapping("/edit/specimen/{specimenCode}")
    public String editSpecimen(Model model, @PathVariable("specimenCode") String specimenCode) {
        if (model.getAttribute("specimen") == null) {
            return("/layouts/view/does_not_exist/generic_does_not_exist");
        }
        return ("layouts/edit/specimen");

    }


    @PostMapping("/edit/specimen/{specimenCode}")
    public String updateSpecimen(@ModelAttribute("specimen") @Validated Specimen specimen, BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("specimen", specimen);
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "layouts/edit/specimen";
        } else {
            Specimen savedSpecimen = specimenService.saveSpecimen(specimen);
            System.out.println("OK");
            return "redirect:/view/specimen/" + savedSpecimen.getSpecimenCode();
        }

    }

    @GetMapping("/search/specimen/byspecimencode")
    public String searchSpecimenBySpecimenCode(@RequestParam String specimenCode, Model model) {
       List<Specimen> specimenList = new ArrayList<Specimen>();
       Optional<Specimen> optionalSpecimen = specimenService.findSingleSpecimenBySpecimenCode(specimenCode);
       if (optionalSpecimen.isEmpty()) {
           return("/layouts/view/does_not_exist/generic_does_not_exist");

       }

       specimenList.add(optionalSpecimen.get());
       model.addAttribute("specimens", specimenList);

       return "layouts/search_result/specimens_result";

    }




}
