package com.arilab.expman.domain.database;


import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "specimen")
public class Specimen implements Serializable {

    @Id
    @Column(unique = true, nullable = false, name = "specimen_id")
    private Integer specimenId;

    @NonNull
    @NotNull
    @NotEmpty(message = "Please enter a specimen code.")
    @Column(name = "specimen_code", unique = true)
    private String specimenCode;

    @Column(name = "sample_code")
    private String sampleCode;

    @ManyToOne
    @JoinColumn(name = "collection_event_code", referencedColumnName = "collection_event_code")
    private CollectionEvent collectionEvent;


    @ManyToOne()
    @JoinColumn(name = "basis_of_record", referencedColumnName = "basis_of_record")
    private BasisOfRecord basisOfRecord;

    @Column(name = "located_at")
    private String locatedAt;

    @Column(name = "owned_by")
    private String ownedBy;

    @Column(name = "lifestagesex")
    private String lifestageSex;

    @Column(name = "medium")
    private String medium;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_status", referencedColumnName = "type_status")
    private TypeStatus typeStatus;

    @Column(name = "taxon_code")
    private String taxonCode;

    @Column(name = "determined_by")
    private String determinedBy;

    @Column(name = "date_identified")
    private String dateIdentified;

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
