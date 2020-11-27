package com.arilab.expman.domain.database.supplementary;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "biogeo_region", schema = "admin")
public class BiogeographicRegion implements Serializable {

    @Id
    @NotNull
    @NonNull
    @NotEmpty
    @Column(nullable = false, name = "region", unique = true)
    private String region;

    @Column(name = "region_note")
    private String regionNote;

}
