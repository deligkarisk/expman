package com.arilab.expman.domain.database.supplementary;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "country",schema = "admin")
public class Country implements Serializable {

    @NonNull
    @NotEmpty
    @Column(name = "country_code",unique = true)
    private String countryCode;

    @Id
    @NonNull
    @NotEmpty
    @Column(name = "country_name", unique = true)
    private String countryName;

    @NonNull
    @NotEmpty
    @Column(name = "iso3_code")
    private String iso3Code;

}
