package com.arilab.expman.domain.database.supplementary;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "specimen_status_types", schema = "admin")
public class TypeStatus {

    @Id
    @Column(name = "type_status_id")
    private Integer typeStatusId;

    @Column(name = "type_status", unique = true)
    private String typeStatus;


}
