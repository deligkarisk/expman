package com.arilab.expman.controller.database;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.domain.database.validator.OnNewLocality;
import com.arilab.expman.service.database.LocalityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class LocalityController {

    LocalityService localityService;

    public LocalityController(LocalityService localityService) {
        this.localityService = localityService;
    }


   @ModelAttribute("locality")
    public Locality localityModel(@PathVariable(value = "localityCode", required = false) String localityCode) {
        Optional<Locality> optionalLocality = localityService.findById(localityCode);
        return optionalLocality.orElse(null);
    }



    @GetMapping("submit/newlocality")
    public String submitNewLocality(Model model, RedirectAttributes redirectAttributes) {
        Locality newLocality = new Locality();
        model.addAttribute("newLocality", newLocality);
        return "submit/new_locality";
    }


    @PostMapping("submit/newlocality")
    public String submitNewLocality(@ModelAttribute("newLocality") @Validated({OnNewLocality.class}) Locality locality,
                                    BindingResult bindingResult, Model model, Errors errors) {


     /*   if (localityService.findById(locality.getLocalityCode()).isPresent()) {
            bindingResult.rejectValue("localityCode", "localitycode.alreadyexists");
        }
        */


        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "submit/new_locality";
        }



        Locality savedLocality = localityService.saveLocality(locality);
        return("redirect:/view/locality/" + locality.getLocalityCode());
    }

    @GetMapping("/view/locality/{localityCode}")
    public String viewLocality(Model model) {

        if (model.getAttribute("locality") == null) {
            return ("does_not_exist");
        }
        return ("view/locality");
    }

    @GetMapping("/edit/locality/{localityCode}")
    public String updateLocality() {
        return ("edit/locality");
    }

    @PostMapping("/edit/locality/{localityCode}")
    public String editLocality(@ModelAttribute("locality") @Validated Locality locality, BindingResult bindingResult
            , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return ("edit/locality");
        }

        localityService.saveLocality(locality);
        return ("redirect:/view/locality/" + locality.getLocalityCode());
    }


    @ResponseBody
    @PostMapping(value = "/exists/locality", headers = "Content-Type=application/json")
    public Boolean localityExists(@RequestParam String localityCode) {
        return localityService.findById(localityCode).isPresent();
    }


}
