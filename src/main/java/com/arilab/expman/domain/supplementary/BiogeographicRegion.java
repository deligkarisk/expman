package com.arilab.expman.domain.supplementary;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "biogeo_region", schema = "admin")
public class BiogeographicRegion implements Serializable {

    @Id
    @ToString.Include
    @NotNull
    @NonNull
    @NotEmpty
    @Column(nullable = false, name = "region", unique = true)
    private String region;

    @Column(name = "region_note")
    private String regionNote;

}
