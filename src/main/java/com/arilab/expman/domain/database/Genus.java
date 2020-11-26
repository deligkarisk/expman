package com.arilab.expman.domain.database;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Genus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genus_id")
    private Integer genusId;

    @NonNull
    @NotNull
    @Column(name = "genus_name")
    private String genusName;

    @ManyToOne
    @JoinColumn(name = "subfamily", referencedColumnName = "subfamily")
    private Subfamily subfamily;

    @Column(name = "tribe")
    private String tribe;

    @Column(name = "genus_note")
    private String genusNote;

    @Column(name = "senior_synonym")
    private String seniorSynonym;

    @Column(name = "usage")
    private Boolean usage;


}
