package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.repository.database.CtScanRepository;
import org.springframework.stereotype.Service;

@Service
public class CtScanService {

    private final CtScanRepository ctScanRepository;

    public CtScanService(CtScanRepository ctScanRepository) {
        this.ctScanRepository = ctScanRepository;
    }

    public CtScan saveCtScan(CtScan ctScan) {
        CtScan savedCtScan = ctScanRepository.save(ctScan);
        return savedCtScan;
    }




}
