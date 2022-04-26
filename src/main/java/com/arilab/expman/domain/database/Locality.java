package com.arilab.expman.domain.database;

import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import com.arilab.expman.domain.database.supplementary.Country;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
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
    @NotEmpty
    @NonNull
    @Column(name = "locality_code")
    private String localityCode;

    @NotNull
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country", referencedColumnName = "country_name", nullable = false)
    private Country country;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "biogeographic_region", referencedColumnName = "region")
    private BiogeographicRegion biogeographicRegion;

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

    public Locality(@NonNull String localityCode) {
        this.localityCode = localityCode;
    }

    @Override
    public String toString() {
        return localityCode;
    }
}
