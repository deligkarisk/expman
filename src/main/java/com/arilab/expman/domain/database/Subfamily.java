package com.arilab.expman.domain.database;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Subfamily implements Serializable {

    @Id
    @Column(name = "subfamily_id")
    private Integer subfamilyId;

    @Column(name = "subfamily")
    private String subfamily;

    @Column(name = "subfamily_note")
    private String subfamilyNote;

}
