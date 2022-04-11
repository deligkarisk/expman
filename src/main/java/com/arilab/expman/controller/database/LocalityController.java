package com.arilab.expman.controller.database;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.service.database.LocalityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "layouts/submit/new_locality";
    }


    @PostMapping("submit/newlocality")
    public String submitNewLocality(@ModelAttribute("newLocality") @Validated Locality locality,
                                    BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return "layouts/submit/new_locality";
        }

        Locality savedLocality = localityService.saveLocality(locality);
        return("redirect:/view/locality/" + locality.getLocalityCode());
    }

    @GetMapping("/view/locality/{localityCode}")
    public String viewLocality(Model model) {

        if (model.getAttribute("locality") == null) {
            return ("layouts/does_not_exist");
        }
        return ("layouts/view/locality");
    }

    @GetMapping("/edit/locality/{localityCode}")
    public String updateLocality() {
        return ("layouts/edit/locality");
    }

    @PostMapping("/edit/locality/{localityCode}")
    public String editLocality(@ModelAttribute("locality") @Validated Locality locality, BindingResult bindingResult
            , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("validationErrors", bindingResult.getAllErrors());
            return ("layouts/edit/locality");
        }

        localityService.saveLocality(locality);
        return ("redirect:/view/locality/" + locality.getLocalityCode());
    }

}
