package com.arilab.expman.controller;

import com.arilab.expman.service.database.CollectionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CollectionEventController {

    @Autowired
    CollectionEventService collectionEventService;

    @RequestMapping("/collectionEventCodesAutocomplete")
    @ResponseBody
    public List<String> collectionEventCodesAutocomplete(@RequestParam (value="term", required = false, defaultValue = "") String term) {
        List<String> suggestions = collectionEventService.getMatchingCollectionEventCodes(term);
                //collectionEventService.getAllCollectionEventCodes();

        return suggestions;
    }

}
