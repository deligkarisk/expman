package com.arilab.expman.domain.database;

import com.arilab.expman.domain.database.validator.OnInsert;
import com.arilab.expman.domain.database.validator.SpeciesNames;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@RequiredArgsConstructor
@SpeciesNames(groups = OnInsert.class)
public class Species {


    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taxon_code")
    private String taxonCode;

    @NonNull
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genus_name", referencedColumnName = "genus_name")
    private Genus genus;

    @Column(name = "species_name")
    private String speciesName;

    @Column(name = "subspecies")
    private String subspecies;

    @Column(name = "morpho_code")
    private String morphoCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senior_synonym")
    private Species seniorSynonym;

    @Column(name = "unacceptibility_reason")
    private String unacceptabilityReason;

    @Column(name = "species_group")
    private String speciesGroup;

    @Column(name = "species_complex")
    private String speciesComplex;

    @Column(name = "affinity")
    private String affinity;

    @Column(name = "vernacular_names")
    private String vernacularNames;

    @Column(name = "type_locality")
    private String typeLocality;

    @Column(name = "type_depository")
    private String typeDepository;

    @Column(name = "usage")
    private Boolean usage;

    @Column(name = "species_author")
    private String speciesAuthor;

    @Column(name = "species_author_year")
    private Long speciesAuthorYear;

    @Column(name = "jira_user")
    private String jiraUser;


}
