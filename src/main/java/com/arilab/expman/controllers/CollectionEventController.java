package com.arilab.expman.controllers;

import com.arilab.expman.service.CollectionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionEventController {

    @Autowired
    CollectionEventService collectionEventService;



}
