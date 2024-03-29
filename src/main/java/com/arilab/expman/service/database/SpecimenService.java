package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.repository.database.SpecimenRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecimenService {

    private final SpecimenRepository specimenRepository;

   SpecimenService(SpecimenRepository specimenRepository) {
       this.specimenRepository = specimenRepository;
   }


   public List<Specimen> findAll() {
       return specimenRepository.findAll();
   }


   public Page<Specimen> findAll(int pageNumber) {
       Pageable pageable = PageRequest.of(pageNumber -1,10);
       return specimenRepository.findAll(pageable);

   }


    public Optional<Specimen> findSingleSpecimenBySpecimenCode(String specimenCode) {
        return specimenRepository.findSingleSpecimenBySpecimenCode(specimenCode);
    }


    public Specimen saveSpecimen(Specimen specimen) {
       Specimen savedSpecimen = specimenRepository.save(specimen);
       return savedSpecimen;
    }


    public List<Specimen> findBySpecimenCodeContainingIgnoreCase(String specimenCode) {
       return specimenRepository.findBySpecimenCodeContainingIgnoreCase(specimenCode);
    }

    public List<Specimen> findByLocalityCodeContainingIgnoreCase(String localityCode) {
       return specimenRepository.findByCollectionEvent_Locality_LocalityCodeContainingIgnoreCase(localityCode);
    }


    public List<Specimen> findByTaxonCodeContainingIgnoreCase(String taxonCode) {
        return specimenRepository.findBySpecies_TaxonCodeContainingIgnoreCase(taxonCode);
    }
}
