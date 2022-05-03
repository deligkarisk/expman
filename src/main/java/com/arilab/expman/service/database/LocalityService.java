package com.arilab.expman.service.database;

import com.arilab.expman.converter.StringToBiogeographicRegion;
import com.arilab.expman.converter.StringToCountry;
import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.dto.domain.LocalityDto;
import com.arilab.expman.repository.database.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    StringToCountry stringToCountryConverter;

    @Autowired
    StringToBiogeographicRegion stringToBiogeographicRegion;

    public Locality convertFromDto(LocalityDto localityDto) {
        Locality locality = new Locality();

        locality.setLocalityCode(localityDto.getLocalityCode());
        if (localityDto.getCountry() != null) {
            locality.setCountry(stringToCountryConverter.convert(localityDto.getCountry()));

        }

        if (localityDto.getBiogeographicRegion() != null) {
            locality.setBiogeographicRegion(stringToBiogeographicRegion.convert(localityDto.getBiogeographicRegion()));
        }



        locality.setAdm1(localityDto.getAdm1());
        locality.setAdm2(localityDto.getAdm2());
        locality.setIslandGroup(localityDto.getIslandGroup());
        locality.setIsland(localityDto.getIsland());
        locality.setLocalityName(localityDto.getLocalityName());
        locality.setLatitude(localityDto.getLatitude());
        locality.setLongitude(localityDto.getLongitude());
        locality.setLatlongError(localityDto.getLatlongError());
        locality.setElevation(localityDto.getElevation());
        locality.setElevationError(localityDto.getElevationError());
        locality.setEmsSite(localityDto.getEmsSite());
        locality.setFjSite(localityDto.getFjSite());
        locality.setEcologicalCommunityOriginal(localityDto.getEcologicalCommunityOriginal());
        locality.setEcologicalCommunityStandard(localityDto.getEcologicalCommunityStandard());
        locality.setDisturbance(localityDto.getDisturbance());
        locality.setAccuracy(localityDto.getAccuracy());
        locality.setOtherSite(localityDto.getOtherSite());

        return locality;
    }
}
