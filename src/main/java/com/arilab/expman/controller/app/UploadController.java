package com.arilab.expman.controller.app;

import com.arilab.expman.csv.mapper.LocalityDtoMapper;
import com.arilab.expman.domain.database.lists.LocalityList;
import com.arilab.expman.dto.collections.LocalityDtoList;
import com.arilab.expman.dto.domain.LocalityDto;
import com.arilab.expman.dto.service.DtoService;
import com.arilab.expman.filesystem.FileUtils;
import com.arilab.expman.service.database.LocalityService;
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
import java.util.Map;
import java.util.Set;

@Controller
public class UploadController {


    LocalityService localityService;
    LocalityDtoMapper localityDtoMapper;

    public UploadController(LocalityService localityService, LocalityDtoMapper localityDtoMapper) {

        this.localityService = localityService;
        this.localityDtoMapper = localityDtoMapper;
    }

    @Autowired
    ConversionService conversionService;

    @Autowired
    FileUtils fileUtils;


    @Autowired
    Validator validator;

    @Autowired
    DtoService dtoService;

    @GetMapping("submit_excel")
    public String excelSubmissionUpload() {
        return("submit/excel");
    }



    @PostMapping("submit_excel")
    public String excelSubmissionSubmit(@RequestParam("multipartFile") MultipartFile multipartFile, Model model) throws IOException {

        File file = fileUtils.multiToSingleFileConversion(multipartFile);
        LocalityDtoList submittedLocalities = localityDtoMapper.mapFileContents(file);
        Map<LocalityDto, Set<ConstraintViolation<LocalityDto>>> errors =
                dtoService.validateLocalityDtos(submittedLocalities);

        if (!errors.isEmpty()) {
            return "locality_upload_error";
        }


     /*   List<Locality> localityList1 = new ArrayList<>();
        for (LocalityDto localityDto: localityDtoList.getLocalityList()) {
            try {
                Locality locality = localityService.convertFromDto(localityDto);
                localityList1.add(locality);
            } catch(Exception ex) {
                System.out.println("error");
            }

              }*/


        //   validator.validate(localityList1.get(0), OnNewLocality.class);

        //  System.out.println("done");

        // return "does_not_exist";

        return "locality_upload_ok";

    }


    @PostMapping(value="submit_batch_localitylist", consumes = "application/json", produces = "application/json")
    public String localityListSubmission(@RequestBody  @Validated LocalityList localityList,
                                         BindingResult bindingResult) {

        return "ok";



    }
}
