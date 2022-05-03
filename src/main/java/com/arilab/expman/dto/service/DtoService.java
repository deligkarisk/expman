package com.arilab.expman.dto.service;

import com.arilab.expman.domain.database.validator.OnBatchLocalityUpload;
import com.arilab.expman.dto.collections.LocalityDtoList;
import com.arilab.expman.dto.domain.LocalityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class DtoService {

    @Autowired
    Validator validator;

    public Map<LocalityDto, Set<ConstraintViolation<LocalityDto>>> validateLocalityDtos(LocalityDtoList localityDtoList) {
        Map<LocalityDto, Set<ConstraintViolation<LocalityDto>>> errors = new HashMap<>();

        for (LocalityDto localityDto : localityDtoList.getLocalityList() ) {
            Set<ConstraintViolation<LocalityDto>> localityErrors = validator.validate(localityDto, OnBatchLocalityUpload.class);
            errors.put(localityDto, localityErrors);
        }

        return errors;
}}
