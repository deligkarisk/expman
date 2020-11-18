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
@Table(name = "country",schema = "admin")
public class Country implements Serializable {

    @Id
    @Column(name = "country_id")
    private Integer countryId;


    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "country_code",unique = true)
    private String countryCode;

    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "country_name", unique = true)
    private String countryName;

    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "iso3_code")
    private String iso3Code;

}
