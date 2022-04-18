package com.arilab.expman.controller.forms;


import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Locality;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompoundCollectionEventController {


    @GetMapping("/submit/newcollectionevent")
    public String submitCompoundCollectionEvent(Model model) {


        model.addAttribute("collection_event", new CollectionEvent());
        model.addAttribute("newLocality", new Locality());
        return "layouts/submit/new_compound_collection_event";
    }
}
