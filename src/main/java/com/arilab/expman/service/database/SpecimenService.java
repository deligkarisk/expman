package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.repository.database.SpecimenRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecimenService {

    private final SpecimenRepository specimenRepository;

   SpecimenService(SpecimenRepository specimenRepository) {
       this.specimenRepository = specimenRepository;
   }

   public Page<Specimen> findAll(int pageNumber) {
       Pageable pageable = PageRequest.of(pageNumber -1,10);
       return specimenRepository.findAll(pageable);

   }


}
