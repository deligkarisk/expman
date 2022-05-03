package com.arilab.expman.dto.domain;

import com.arilab.expman.domain.database.validator.OnBatchLocalityUpload;
import com.arilab.expman.dto.validator.BioGeoRegionExistsOrIsNull;
import com.arilab.expman.dto.validator.CountryExists;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@JsonIgnoreProperties
@Data
public class LocalityDto {


    @NotEmpty
    private String localityCode;

    @CountryExists(groups = OnBatchLocalityUpload.class)
    private String country;
    private String adm1;
    private String adm2;
    private String islandGroup;
    private String island;
    private String localityName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Float latlongError;
    private BigDecimal elevation;
    private BigDecimal elevationError;

    @BioGeoRegionExistsOrIsNull(groups = OnBatchLocalityUpload.class)
    private String biogeographicRegion;

    private String emsSite;
    private String fjSite;
    private String ecologicalCommunityOriginal;
    private String ecologicalCommunityStandard;
    private Short disturbance;
    private Short accuracy;
    private String otherSite;

}
