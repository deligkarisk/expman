package com.arilab.expman.dto.error;

import com.arilab.expman.dto.collections.LocalityDtoList;
import com.arilab.expman.dto.domain.LocalityDto;

import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LocalityDtoListError {

    Map<LocalityDto, Set<ConstraintViolation<LocalityDtoList>>> errors = new HashMap<>();

}
