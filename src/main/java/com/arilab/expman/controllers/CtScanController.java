package com.arilab.expman.controllers;

import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.service.database.CtScanService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("ctscan")
public class CtScanController {

    private CtScanService ctScanService;

    public CtScanController(CtScanService ctScanService) {
        this.ctScanService = ctScanService;
    }

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/view/ctscan/{ctScanId}")
    public String viewCtScan(Model model, @PathVariable("ctScanId") Long ctScanId) {
        Optional<CtScan> ctScan = ctScanService.findById(ctScanId);
        if (ctScan.isEmpty()) {
            return("layouts/view/does_not_exist/generic_does_not_exist");
        }
        model.addAttribute("ctscan",ctScan.get());
        return("layouts/view/ctscan");
    }

    @GetMapping("/edit/ctscan/{ctScanId}")
    public String editCtScan(Model model, @PathVariable("ctScanId") Long ctScanId) {
        Optional<CtScan> ctScan = ctScanService.findById(ctScanId);
        if (ctScan.isEmpty()) {
            return("layouts/view/does_not_exist/generic_does_not_exist");
        }
        model.addAttribute("ctscan", ctScan.get());
        return("layouts/edit/ctscan");
    }

    @PostMapping("/edit/ctscan")
    public String updateCtScan(@ModelAttribute("ctscan") @Validated CtScan ctScan, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return("layouts/edit/ctscan");
        }

        CtScan savedCtScan = ctScanService.saveCtScan(ctScan);
        return("redirect:/view/ctscan/" + savedCtScan.getScanId());

    }





    @GetMapping("/new/ctscan")
    public String newCtScan(Model model) {
        CtScan ctScan = new CtScan();
        model.addAttribute("ctScan", ctScan);
        return "layouts/edit/ctscan";
    }




    @GetMapping("/explore/ctscans")
    public String exploreCtScans(Model model) {

        return"layouts/explore/ctscans";
    }



}
