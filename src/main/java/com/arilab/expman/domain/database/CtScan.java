package com.arilab.expman.domain.database;

import com.arilab.expman.domain.database.enums.BodyPart;
import com.arilab.expman.domain.database.enums.Model;
import com.arilab.expman.domain.database.validator.CtScanAntScanCoding;
import com.arilab.expman.domain.database.validator.CtScanDryMethodValues;
import com.arilab.expman.domain.database.validator.CtScanDryWetFields;
import com.arilab.expman.domain.database.validator.OnInsert;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@NamedEntityGraph(name = "CtScan.Basic", attributeNodes = {
        @NamedAttributeNode(value = "specimen", subgraph = "subgraph.specimen")},
                  subgraphs = {
                          @NamedSubgraph(name = "subgraph.specimen", attributeNodes = {
                                  @NamedAttributeNode(value = "collectionEvent",
                                                      subgraph = "subgraph.collectionEvent")
                          }),
                          @NamedSubgraph(name = "subgraph.collectionEvent", attributeNodes = {
                                  @NamedAttributeNode(value = "locality")
                          })
                  }
)
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "ctscans")
@CtScanAntScanCoding(groups = OnInsert.class)
@CtScanDryWetFields(groups = OnInsert.class)
@CtScanDryMethodValues(groups = OnInsert.class)
public class CtScan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_scan_id", unique = true)
    private Long scanId;



    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "specimen_code", referencedColumnName = "specimen_code")
    private Specimen specimen;

    @Column(name = "ct_scan_note")
    private String ctScanNote;

    @NotEmpty
    @NonNull
    @Column(name = "ethanol_conc")
    private String ethanolConcentration;

    @NotEmpty
    @NonNull
    @Column(name = "wet")
    private String wet;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_part")
    private BodyPart bodyPart;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "model")
    private Model model;

    @Column(name = "dry_method")
    private String dryMethod;

    @Column(name = "scan_reason")
    private String scanReason;

    @Column(name = "prep_note")
    private String prepNote;

}
