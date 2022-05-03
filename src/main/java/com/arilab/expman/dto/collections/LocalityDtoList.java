package com.arilab.expman.dto.collections;

import com.arilab.expman.dto.domain.LocalityDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Validator;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Component
public class LocalityDtoList implements Serializable {

    Validator validator;
    List<LocalityDto> localityList;

/*
    }*/
}
