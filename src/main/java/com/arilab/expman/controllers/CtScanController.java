package com.arilab.expman.controllers;

import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.service.database.CtScanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtScanController {

    private CtScanService ctScanService;

    public CtScanController(CtScanService ctScanService) {
        this.ctScanService = ctScanService;
    }

    @GetMapping("/new/CtScan")
    public String newCtScan(Model model) {
        CtScan ctScan = new CtScan();
        model.addAttribute("ctScan", ctScan);
        return"layouts/new/ct_scan";

    }



}
