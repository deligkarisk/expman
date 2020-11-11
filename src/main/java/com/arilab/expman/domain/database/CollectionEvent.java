package com.arilab.expman.domain.database;


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
@Table(name = "collection_event")
@NoArgsConstructor
@RequiredArgsConstructor
public class CollectionEvent implements Serializable {

    @Id
    @Column(name = "collection_event_id")
    private Integer collectionEventId;

    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "collection_event_code", unique = true)
    private String collectionEventCode;

    @NonNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "locality_code", referencedColumnName = "locality_code")
    private Locality locality;

    @Column(name = "collected_by")
    private String collectedBy;

    @Column(name = "method")
    private String method;

    @Column(name = "sampling_effort")
    private String samplingEffort;

    @Column(name = "date_collected_start")
    private String dateCollectedStart;

    @Column(name = "date_collected_end")
    private String dateCollectedEnd;

    @Column(name = "date_flag")
    private Integer dateFlag;

    @Column(name = "habitat")
    private String habitat;

    @Column(name = "microhabitat")
    private String microhabitat;

    @Column(name = "behavior")
    private String behavior;

    @Column(name = "disturbance_level")
    private String disturbanceLevel;

    @Column(name = "jira_user")
    private String jiraUser;










}
