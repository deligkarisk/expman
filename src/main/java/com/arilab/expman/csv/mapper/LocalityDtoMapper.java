package com.arilab.expman.csv.mapper;

import com.arilab.expman.dto.collections.LocalityDtoList;
import com.arilab.expman.dto.domain.LocalityDto;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Component
public class LocalityDtoMapper {

    @Autowired
    Validator validator;

    LocalityDtoList localityDtoList = new LocalityDtoList();

    public LocalityDtoList mapFileContents(File sourceFile) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        MappingIterator<LocalityDto> localityMappingIterator = mapper
                .readerFor(LocalityDto.class)
                .with(schema)
                .readValues(sourceFile);
        List<LocalityDto> internalLocalityDtoList = localityMappingIterator.readAll();
        localityDtoList.setLocalityList(internalLocalityDtoList);
        return localityDtoList;

    }
}
