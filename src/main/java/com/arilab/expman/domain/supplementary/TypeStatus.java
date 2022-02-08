package com.arilab.expman.domain.supplementary;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "specimen_status_types", schema = "admin")
public class TypeStatus implements Serializable {


    @Column(name = "type_status_id")
    private Integer typeStatusId;

    @Id
    @ToString.Include
    @Column(name = "type_status", unique = true)
    private String typeStatus;

}
