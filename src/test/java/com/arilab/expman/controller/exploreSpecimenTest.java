package com.arilab.expman.controller;

import com.arilab.expman.controller.database.SpecimenController;
import com.arilab.expman.service.database.SpecimenService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class exploreSpecimenTest {

    @Mock
    SpecimenService specimenService;

    @InjectMocks
    private SpecimenController specimenController;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(specimenController).build();

    }




}
