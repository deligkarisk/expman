package com.arilab.expman.controller;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.service.database.SpecimenService;
import com.arilab.expman.service.database.supplementary.BasisOfRecordService;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpecimenControllerTest {


    Integer PAGE_SIZE = 10;

    @Value("${REFERENCE_SPECIMEN_CODE}")
    String REFERENCE_SPECIMEN_CODE;

    WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BasisOfRecordService basisOfRecordService;

    @Autowired
    SpecimenService specimenService;

    @Before
    public void setUpMockito() {
        MockitoAnnotations.initMocks(this);

        webClient = MockMvcWebClientBuilder
                .mockMvcSetup(mockMvc)
                .contextPath("")
                .build();
    }



    @After
    public void close() throws Exception {
       webClient.close();
    }


    @Test
    public void exploreSpecimensTest() throws Exception {

        mockMvc.perform(get("/explore/specimens")).andExpect(status().isOk())
                .andExpect(view().name("explore/specimens"))
                .andExpect(model().attribute("specimens", instanceOf(List.class)))
                .andExpect(model().attribute("specimens", hasSize(PAGE_SIZE)))
                .andExpect(model().attribute("currentPage", instanceOf(int.class)))
                .andExpect(model().attribute("totalPages", instanceOf(int.class)))
                .andExpect(model().attribute("totalSpecimens", instanceOf(long.class)));

        mockMvc.perform(get("/explore/specimens/page/1")).andExpect(status().isOk())
                .andExpect(view().name("explore/specimens"))
                .andExpect(model().attribute("specimens", instanceOf(List.class)))
                .andExpect(model().attribute("specimens", hasSize(PAGE_SIZE)))
                .andExpect(model().attribute("currentPage", instanceOf(int.class)))
                .andExpect(model().attribute("totalPages", instanceOf(int.class)))
                .andExpect(model().attribute("totalSpecimens", instanceOf(long.class)));

    }



    @Test
    public void editSpecimenTest() throws Exception {

        mockMvc.perform(get("/edit/specimen/" + REFERENCE_SPECIMEN_CODE)).andExpect(status().isOk())
                .andExpect(view().name("edit/specimen"))
                .andExpect(model().attribute("specimen", instanceOf(Specimen.class)));

    }





}
