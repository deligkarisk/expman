package com.arilab.expman.domain.database;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "specimen")
public class Specimen {

    @Id
    @Column(unique = true, nullable = false, name = "specimen_id")
    private Integer specimenId;

    @NonNull
    @NotEmpty(message = "Please enter a specimen code.")
    @Column(name = "specimen_code", unique = true)
    private String specimenCode;

    @Column(name = "sample_code")
    private String sampleCode;

    @Column(name = "collection_event_code")
    private String collectionEventCode;

    @Column(name = "basis_of_record")
    private String basisOfRecord;

    @Column(name = "located_at")
    private String locatedAt;

    @Column(name = "owned_by")
    private String ownedBy;

    @Column(name = "lifestagesex")
    private String lifestageSex;

    @Column(name = "medium")
    private String medium;

    @NonNull
    @NotEmpty(message = "Please enter the type status of the specimen.")
    @Column(name = "type_status")
    private String typeStatus;

    @Column(name = "taxon_code")
    private String taxonCode;

    @Column(name = "determined_by")
    private String determinedBy;

    @Column(name = "fba_code")
    private String fbaCode;

    @Column(name = "fj_code")
    private String fjCode;

    @Column(name = "epe_code")
    private String epeCode;

    @Column(name = "ems_code")
    private String emsCode;

    @Column(name = "other_code")
    private String otherCode;

    @Column(name = "flag")
    private String flag;

    @Column(name = "transect_notes")
    private String transectNotes;

    @Column(name = "antweb_manage")
    private Short antwebManage;
}
