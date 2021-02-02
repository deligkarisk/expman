package com.arilab.expman.domain.database;

import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@NamedEntityGraph(name = "Specimen.GlobalFetchAll",
                  attributeNodes = {@NamedAttributeNode("typeStatus"),
                                    @NamedAttributeNode(value = "collectionEvent",
                                                        subgraph = "subgraph.collectionEvent"),
                                    @NamedAttributeNode("basisOfRecord")},
                  subgraphs = {@NamedSubgraph(name = "subgraph.collectionEvent",
                                              attributeNodes = {@NamedAttributeNode(value = "locality",
                                                                                    subgraph = "subgraph.locality")}),
                               @NamedSubgraph(name = "subgraph.locality",
                                              attributeNodes = {@NamedAttributeNode(value = "country"),
                                                                @NamedAttributeNode(value = "biogeographicRegion")})})
@NamedEntityGraph(name = "Specimen.GlobalFetchBasic",
                  attributeNodes = {@NamedAttributeNode(value = "collectionEvent",
                                                        subgraph = "subgraph.collectionEvent"),
                                    @NamedAttributeNode(value = "species")},
                  subgraphs = {@NamedSubgraph(name = "subgraph.collectionEvent",
                                              attributeNodes = {@NamedAttributeNode(value = "locality")})})



@Table(name = "specimen")
public class Specimen {

    @Id
    @NonNull
    @NotNull
    @ToString.Include
    @NotEmpty(message = "Please enter a specimen code.")
    @Column(name = "specimen_code", unique = true, nullable = false)
    private String specimenCode;

    @Column(name = "sample_code")
    private String sampleCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "collection_event_code", referencedColumnName = "collection_event_code")
    private CollectionEvent collectionEvent;


    @ManyToOne(fetch = FetchType.LAZY)
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

    @NotNull
    @NonNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_status", referencedColumnName = "type_status")
    private TypeStatus typeStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxon_code", referencedColumnName = "taxon_code")
    private Species species;

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
