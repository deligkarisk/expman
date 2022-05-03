package com.arilab.expman.domain.database.lists;

import com.arilab.expman.domain.database.Locality;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class LocalityList implements Serializable  {

    @Valid
    List<Locality> localityList;

}
