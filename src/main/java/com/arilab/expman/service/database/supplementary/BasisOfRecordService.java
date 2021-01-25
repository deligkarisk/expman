package com.arilab.expman.service.database.supplementary;

import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.repository.database.supplementary.BasisOfRecordRepository;
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
