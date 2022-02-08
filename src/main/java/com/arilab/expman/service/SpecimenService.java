package com.arilab.expman.service;

import com.arilab.expman.domain.Specimen;
import com.arilab.expman.repository.SpecimenRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

   public Optional<Specimen> findBySpecimenCode(String specimenCode) {
       return specimenRepository.findBySpecimenCode(specimenCode);
   }


    public Optional<Specimen> findSingleSpecimenBySpecimenCode(String specimenCode) {
        return specimenRepository.findSingleSpecimenBySpecimenCode(specimenCode);
    }


    public Specimen saveSpecimen(Specimen specimen) {
       Specimen savedSpecimen = specimenRepository.save(specimen);
       return savedSpecimen;
    }






}
