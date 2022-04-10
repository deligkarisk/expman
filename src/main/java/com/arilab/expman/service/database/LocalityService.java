package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.repository.database.LocalityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalityService {

    LocalityRepository localityRepository;

    public LocalityService(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    public Locality saveLocality(Locality locality) {
        return localityRepository.save(locality);
    }

    public Optional<Locality> findById(String localityCode) {
        return localityRepository.findByLocalityCode(localityCode);
    }
}
