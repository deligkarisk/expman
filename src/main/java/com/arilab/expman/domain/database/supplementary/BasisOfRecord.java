package com.arilab.expman.domain.database.supplementary;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "specimen_basis_of_record", schema = "supplementary")
public class BasisOfRecord implements Serializable {

    @Id
    @Column(name = "basis_of_record", nullable = false)
    @NonNull
    @NotNull
    @NotEmpty
    private String basisOfRecord;



}
