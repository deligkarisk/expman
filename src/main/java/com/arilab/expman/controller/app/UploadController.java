package com.arilab.expman.controller.app;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.domain.database.lists.LocalityList;
import com.arilab.expman.domain.database.validator.OnBatchLocalityUpload;
import com.arilab.expman.domain.database.validator.OnNewLocality;
import com.arilab.expman.dto.domain.LocalityDto;
import com.arilab.expman.mapping.domain.LocalityDtoList;
import com.arilab.expman.service.database.LocalityService;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UploadController {

    LocalityService localityService;

    public UploadController(LocalityService localityService) {
        this.localityService = localityService;
    }

    @Autowired
    ConversionService conversionService;


    @Autowired
    Validator validator;

    @GetMapping("submit_excel")
    public String excelSubmissionUpload() {
        return("submit/excel");
    }



    @PostMapping("submit_excel")
    public String excelSubmissionSubmit(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        File newFile =  new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                file.getOriginalFilename());

        file.transferTo(newFile);

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        MappingIterator<LocalityDto> localityMappingIterator = mapper
                .readerFor(LocalityDto.class)
                .with(schema)
                .readValues(newFile);
        List<LocalityDto> localityList = localityMappingIterator.readAll();

        Set<ConstraintViolation<LocalityDto>> errors = validator.validate(localityList.get(0), OnBatchLocalityUpload.class);

        if (!errors.isEmpty()) {
            return "upload_error";
        }

        LocalityDtoList localityDtoList = new LocalityDtoList();
        localityDtoList.setLocalityList(localityList);

        List<Locality> localityList1 = new ArrayList<>();
        for (LocalityDto localityDto: localityDtoList.getLocalityList()) {
            try {
                Locality locality = localityService.convertFromDto(localityDto);
                localityList1.add(locality);
            } catch(Exception ex) {
                System.out.println("error");
            }
        }


        validator.validate(localityList1.get(0), OnNewLocality.class);

        System.out.println("done");

        return "does_not_exist";

    }


    @PostMapping(value="submit_batch_localitylist", consumes = "application/json", produces = "application/json")
    public String localityListSubmission(@RequestBody  @Validated LocalityList localityList,
                                         BindingResult bindingResult) {

        return "ok";



    }
}
