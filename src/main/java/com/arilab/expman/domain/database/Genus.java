package com.arilab.expman.domain.database;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
public class Genus implements Serializable {


    @Id
    @NonNull
    @NotNull
    @ToString.Include
    @Column(name = "genus_name")
    private String genusName;

    @ManyToOne(fetch = FetchType.LAZY)
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
