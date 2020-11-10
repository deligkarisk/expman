package com.arilab.expman.domain.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Locality implements Serializable {

    @Id
    @Column(name = "locality_id")
    private Integer localityId;

    @Column(name = "locality_code")
    @NotEmpty
    @NotNull
    @NonNull
    private String localityCode;

    @Column(name = "country")
    @NotEmpty
    @NotNull
    @NonNull
    private String country;

    @Column(name = "adm1")
    private String adm1;

    @Column(name = "adm2")
    private String adm2;

    @Column(name = "island_group")
    private String islandGroup;

    @Column(name = "island")
    private String island;

    @Column(name = "locality_name")
    private String localityName;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "latlong_error")
    private Float latlongError;

    @Column(name = "elevation")
    private BigDecimal elevation;

    @Column(name = "elevation_error")
    private BigDecimal elevationError;

    @Column(name = "biogeographic_region")
    private String biogeographicRegion;

    @Column(name = "ems_site")
    private String emsSite;

    @Column(name = "fj_site")
    private String fjSite;

    @Column(name = "ecological_community_original")
    private String ecologicalCommunityOriginal;

    @Column(name = "ecological_community_standard")
    private String ecologicalCommunityStandard;

    @Column(name = "disturbance")
    private Short disturbance;

    @Column(name = "accuracy")
    private Short accuracy;

    @Column(name = "other_site")
    private String otherSite;

    @Column(name = "jira_user")
    private String jiraUser;





}
