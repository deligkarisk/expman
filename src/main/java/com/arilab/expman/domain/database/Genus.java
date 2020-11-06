package com.arilab.expman.domain.database;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Genus {

    @Id
    @Column(name = "genus_id")
    private Integer genusId;

    @Column(name = "genus_name")
    private String genusName;

    @Column(name = "subfamily")
    private String subfamily;

    @Column(name = "tribe")
    private String tribe;

    @Column(name = "genus_note")
    private String genusNote;

    @Column(name = "senior_synonym")
    private String seniorSynonym;

    @Column(name = "usage")
    private Boolean usage;


}
