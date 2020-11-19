package com.arilab.expman.domain.database;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "ctscans")
public class CtScan {

    @Id
    @Column(name = "ct_scan_id", unique = true)
    private Long scanId;


    @ManyToOne
    @JoinColumn(name = "specimen_code", referencedColumnName = "specimen_code")
    private Specimen specimen;

    @Column(name = "ct_scan_note")
    private String ctScanNote;

    @NotEmpty
    @NonNull
    @Column(name = "ethanol_conc")
    private String ethanolConcentration;

    @Column(name = "wet")
    private String wet;

    @Column(name = "body_part")
    private String bodyPart;

    @Column(name = "special_identifier")
    private String specialIdentifier;

    @Column(name = "folder_location")
    private String folderLocation;


    @NotEmpty
    @NonNull
    @Column(name = "scan_user")
    private String scanUser;

    @Column(name = "staining")
    private String staining;

    @NonNull
    @NotEmpty
    @Column(name = "antscan")
    private String antscan;

    @Column(name = "antscan_code")
    private String antscanCode;

    @Column(name = "model")
    private String model;

    @Column(name = "dry_method")
    private String dryMethod;

    @Column(name = "scan_reason")
    private String scanReason;

    @Column(name = "prep_note")
    private String prepNote;

}
