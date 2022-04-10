package com.arilab.expman.controller.database;

import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.service.database.CtScanService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CtScanController {

    private CtScanService ctScanService;

    public CtScanController(CtScanService ctScanService) {
        this.ctScanService = ctScanService;
    }

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @ModelAttribute("ctscan")
    public CtScan ctScanModel(@PathVariable(value = "ctScanId", required = false) Long ctScanId) {
        if (ctScanId == null) {
            return null;
        }

        Optional<CtScan> ctScan = ctScanService.findById(ctScanId);
        return ctScan.orElse(null);
    }

    @GetMapping("/view/ctscan/{ctScanId}")
    public String viewCtScan(Model model, @PathVariable(value = "ctScanId") Long ctScanId) {
        if (model.getAttribute("ctscan") == null) {
            return ("layouts/does_not_exist");
        }
        return ("layouts/view/ctscan");
    }

    @GetMapping("/edit/ctscan/{ctScanId}")
    public String editCtScan(Model model, @PathVariable("ctScanId") Long ctScanId) {
        if (model.getAttribute("ctscan") == null) {
            return ("layouts/does_not_exist");
        }
        return ("layouts/edit/ctscan");
    }

    @PostMapping("/edit/ctscan/{ctScanId}")
    public String updateCtScan(@ModelAttribute("ctscan") @Validated CtScan ctScan, BindingResult bindingResult, Model model, SessionStatus sessionStatus) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return ("layouts/edit/ctscan");
        }

        CtScan savedCtScan = ctScanService.saveCtScan(ctScan);
        return ("redirect:/view/ctscan/" + savedCtScan.getScanId());
    }


    @GetMapping("/new/ctscan")
    public String newCtScan(Model model) {
        CtScan ctScan = new CtScan();
        model.addAttribute("ctscan", ctScan);
        return "layouts/edit/ctscan";
    }


    @GetMapping("/explore/ctscans")
    public String exploreCtScans(Model model) {

        return exploreCtscansByPage(model, 1);
    }

    @GetMapping("/explore/ctscans/page/{pageNumber}")
    public String exploreCtscansByPage(Model model, @PathVariable("pageNumber") int currentPage) {

        Page<CtScan> ctscanPage = ctScanService.findAll(currentPage);
        int totalPages = ctscanPage.getTotalPages();
        long totalCtscans = ctscanPage.getTotalElements();
        List<CtScan> ctScans = ctscanPage.getContent();
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("ctscans", ctScans);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalCtscans", totalCtscans);

        return "layouts/explore/ctscans";
    }

    @GetMapping("/search/ctscan/byspecimencode")
    public String searchCtScansBySpecimenCodeLike(@RequestParam String specimenCode, Model model,
                                                  RedirectAttributes redirectAttributes) {
        List<CtScan> ctScansList = ctScanService.findBySpecimenCodeContainingIgnoreCase(specimenCode);
        return showCtScansSearchResults(redirectAttributes, ctScansList);
    }

    @GetMapping("/search/ctscan/bylocalitycode")
    public String searchCtScansByLocalityCodeLike(@RequestParam String localityCode, Model model,
                                                  RedirectAttributes redirectAttributes) {
        List<CtScan> ctScansList = ctScanService.findByLocalityCodeContainingIgnoreCase(localityCode);
        return showCtScansSearchResults(redirectAttributes, ctScansList);
    }

    @GetMapping("/search/ctscan/bytaxoncode")
    public String searchCtScansByTaxonCodeLike(@RequestParam String taxonCode, Model model,
                                                  RedirectAttributes redirectAttributes) {
        List<CtScan> ctScansList = ctScanService.findByTaxonCodeContainingIgnoreCase(taxonCode);
        return showCtScansSearchResults(redirectAttributes, ctScansList);
    }





    private String showCtScansSearchResults(RedirectAttributes redirectAttributes, List<CtScan> ctScans) {
        if (ctScans.isEmpty()) {
            return("layouts/does_not_exist");
        }

        boolean dataLimitExceeded;

        if (ctScans.size() > 1000) {
            dataLimitExceeded = true;
            ctScans = ctScans.subList(0, 1000);
        } else {
            dataLimitExceeded = false;
        }

        redirectAttributes.addFlashAttribute("ctScans", ctScans);
        redirectAttributes.addFlashAttribute("dataLimitExceeded", dataLimitExceeded);

        return "redirect:/search_result/ctscans_result";
    }

    @GetMapping("/search_result/ctscans_result")
    public String showCtScans() {
        return "layouts/search_result/ctscans_result";
    }
}
