package com.arilab.expman.controller.forms;


import com.arilab.expman.forms.CompoundCollectionEvent;
import com.arilab.expman.service.database.CollectionEventService;
import com.arilab.expman.service.database.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompoundCollectionEventController {

    @Autowired
    Validator validator;

    CollectionEventService collectionEventService;
    LocalityService localityService;

    public CompoundCollectionEventController(CollectionEventService collectionEventService, LocalityService localityService) {
        this.collectionEventService = collectionEventService;
        this.localityService = localityService;
    }

    @InitBinder     /* Converts empty strings into null when a form is submitted */
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/submit/newcollectionevent")
    public String submitCompoundCollectionEvent(Model model) {

        model.addAttribute("compound_collection_event", new CompoundCollectionEvent());
        model.addAttribute("localityCodeRequired", false);

        // model.addAttribute("collection_event", new CollectionEvent());
       // model.addAttribute("newLocality", new Locality());
        return "submit/new_compound_collection_event";
    }

    @PostMapping("/submit/newcollectionevent")
    public String submitCompoundCollectionEvent(@ModelAttribute  CompoundCollectionEvent compoundCollectionEvent,
                                                BindingResult bindingResult, Model model) {


        Errors compoundErrors = new BeanPropertyBindingResult(compoundCollectionEvent,
                compoundCollectionEvent.getClass().getName());
        validator.validate(compoundCollectionEvent, compoundErrors);

        if (compoundErrors.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("compound_collection_event", compoundCollectionEvent);
            model.addAttribute("localityCodeRequired", false);
            return "submit/new_compound_collection_event";
        }


        if (compoundCollectionEvent.getLocality() != null) {
            compoundCollectionEvent.getCollectionEvent().setLocality(compoundCollectionEvent.getLocality());
        }

        Errors finalObjectErrors = new BeanPropertyBindingResult(compoundCollectionEvent,
                compoundCollectionEvent.getClass().getName());
        validator.validate(compoundCollectionEvent, finalObjectErrors);

        collectionEventService.saveCollectionEvent(compoundCollectionEvent.getCollectionEvent());




       /* if ((collectionEvent.getLocality() == null) && (locality != null)) {
            collectionEvent.setLocality(locality);
        }
*/
        return "redirect:/explore/specimens";
    }
}
