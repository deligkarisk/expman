package com.arilab.expman.mapping.domain;

import com.arilab.expman.dto.domain.LocalityDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class LocalityDtoList implements Serializable {

    List<LocalityDto> localityList;
}
