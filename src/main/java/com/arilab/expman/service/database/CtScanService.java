package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.repository.database.CtScanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CtScanService {

    private final CtScanRepository ctScanRepository;

    public CtScanService(CtScanRepository ctScanRepository) {
        this.ctScanRepository = ctScanRepository;
    }


    public List<CtScan> findAll() {
        return ctScanRepository.findAll();
    }


    public Page<CtScan> findAll(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1,10);
        return ctScanRepository.findAll(pageable);
    }



    public CtScan saveCtScan(CtScan ctScan) {
        CtScan savedCtScan = ctScanRepository.save(ctScan);
        return savedCtScan;
    }

    public Optional<CtScan> findById(Long ctScanId) {
        Optional<CtScan> ctScan = ctScanRepository.findById(ctScanId);
        return ctScan;
    }
}
