package com.arilab.expman.domain.database;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ctscans")
public class CTScan {

    @Id
    @Column(name = "ct_scan_id", unique = true)
    private Long scanId;


}
