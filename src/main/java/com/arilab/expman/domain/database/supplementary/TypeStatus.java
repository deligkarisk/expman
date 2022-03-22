package com.arilab.expman.domain.database.supplementary;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "specimen_status_types", schema = "admin")
public class TypeStatus implements Serializable {


    @Column(name = "type_status_id")
    private Integer typeStatusId;

    @Id
    @NotEmpty
    @NonNull
    @ToString.Include
    @Column(name = "type_status", unique = true)
    private String typeStatus;

    public String toString() {
        return this.typeStatus;
    }


}
