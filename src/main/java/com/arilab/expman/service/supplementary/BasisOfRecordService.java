package com.arilab.expman.service.supplementary;

import com.arilab.expman.domain.supplementary.BasisOfRecord;
import com.arilab.expman.repository.supplementary.BasisOfRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasisOfRecordService {

    private final BasisOfRecordRepository basisOfRecordRepository;


    public BasisOfRecordService(
            BasisOfRecordRepository basisOfRecordRepository) {
        this.basisOfRecordRepository = basisOfRecordRepository;
    }

    public List<BasisOfRecord> findAll() {
        return basisOfRecordRepository.findAll();
    }
}
