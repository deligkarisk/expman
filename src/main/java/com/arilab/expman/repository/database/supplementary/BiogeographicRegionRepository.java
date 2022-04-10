package com.arilab.expman.repository.database.supplementary;

import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiogeographicRegionRepository extends JpaRepository<BiogeographicRegion,String>  {


    @Query(value = "SELECT region FROM admin.biogeo_region WHERE region LIKE %?1%",
            nativeQuery = true)
    public List<String> getMatchingBiogeographicRegions(String matchString);

}
