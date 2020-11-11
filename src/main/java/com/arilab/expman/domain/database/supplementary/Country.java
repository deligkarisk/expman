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

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "country",schema = "admin")
public class Country {

    @Id
    @Column(name = "country_id")
    private Integer countryId;


    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "country_code")
    private String countryCode;

    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "country_name")
    private String countryName;

    @NotNull
    @NonNull
    @NotEmpty
    @Column(name = "iso3_code")
    private String iso3Code;

}
