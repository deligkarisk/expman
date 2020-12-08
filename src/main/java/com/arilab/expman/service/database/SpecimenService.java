package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.repository.database.SpecimenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecimenService {

    private final SpecimenRepository specimenRepository;

   SpecimenService(SpecimenRepository specimenRepository) {
       this.specimenRepository = specimenRepository;
   }

   public List<Specimen> findAll() {
       return specimenRepository.findAll();

   }


}
