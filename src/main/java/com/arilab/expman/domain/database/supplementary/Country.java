package com.arilab.expman.domain.database.supplementary;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
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
    @ToString.Include
    @Column(name = "country_name", unique = true)
    private String countryName;

    @NonNull
    @NotEmpty
    @Column(name = "iso3_code")
    private String iso3Code;

    @Override
    public String toString() {
        return countryName;
    }
}
