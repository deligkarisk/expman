package com.arilab.expman.domain.database.supplementary;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "biogeo_region", schema = "admin")
public class BiogeographicRegion {

    @Id
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region")
    private String region;

    @Column(name = "region_note")
    private String regionNote;

}
