package com.arilab.expman.domain.database.supplementary;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "specimen_status_types", schema = "admin")
public class TypeStatus implements Serializable {


    @Column(name = "type_status_id")
    private Integer typeStatusId;

    @Id
    @Column(name = "type_status", unique = true)
    private String typeStatus;

}
