package com.arilab.expman.domain.database;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Subfamily implements Serializable {


    @Column(name = "subfamily_id")
    private Integer subfamilyId;

    @Id
    @ToString.Include
    @Column(name = "subfamily")
    private String subfamily;

    @Column(name = "subfamily_note")
    private String subfamilyNote;

}
