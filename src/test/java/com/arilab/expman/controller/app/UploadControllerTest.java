package com.arilab.expman.controller.app;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class UploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void excelSubmissionSubmit() throws Exception {

        MockMultipartFile file = new MockMultipartFile(
                "multipartFile", "locality_data.csv", "text/csv",
                new ClassPathResource("batch_locality_upload_test.csv").getInputStream());

        mockMvc.perform(MockMvcRequestBuilders.multipart("/submit_excel")
                .file(file)).andExpect(status().isOk());
    }
}