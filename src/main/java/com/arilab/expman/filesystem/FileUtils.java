package com.arilab.expman.filesystem;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtils {

    public File multiToSingleFileConversion(MultipartFile multipartFile) throws IOException {

        File newFile =  new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                multipartFile.getOriginalFilename());

        multipartFile.transferTo(newFile);

        return newFile;

    }
}
