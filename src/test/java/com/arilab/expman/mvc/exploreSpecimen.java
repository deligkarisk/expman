package com.arilab.expman.mvc;

import com.arilab.expman.controllers.DatabaseController;
import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.service.database.SpecimenService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.xml.crypto.Data;
import java.awt.print.Pageable;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class exploreSpecimen {

    @Mock
    SpecimenService specimenService;

    @InjectMocks
    private DatabaseController databaseController;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(databaseController).build();

    }


    @Test
    public void testSpecimensExplore() throws Exception {

        int sizeOfList = 2; // size of generated list below
        List<Specimen> specimens = new LinkedList<Specimen>();
        Specimen specimen1 = new Specimen();
        specimen1.setSpecimenCode("TestCode001");
        specimens.add(specimen1);
        Specimen specimen2 = new Specimen();
        specimen1.setSpecimenCode("TestCode002");
        specimens.add(specimen2);
        Page<Specimen> specimenPage = new PageImpl(specimens);

        when(specimenService.findAll(1)).thenReturn(specimenPage);

        mockMvc.perform(get("/explore/specimens")).andExpect(status().isOk())
        .andExpect(view().name("layouts/explore/specimens"))
        .andExpect(model().attribute("specimens", instanceOf(List.class)))
        .andExpect(model().attribute("specimens", hasSize(sizeOfList)))
        .andExpect(model().attribute("currentPage", instanceOf(int.class)))
        .andExpect(model().attribute("totalPages", instanceOf(int.class)))
        .andExpect(model().attribute("totalSpecimens", instanceOf(long.class)));

        mockMvc.perform(get("/explore/specimens/page/1")).andExpect(status().isOk())
                .andExpect(view().name("layouts/explore/specimens"))
                .andExpect(model().attribute("specimens", instanceOf(List.class)))
                .andExpect(model().attribute("specimens", hasSize(sizeOfList)))
                .andExpect(model().attribute("currentPage", instanceOf(int.class)))
                .andExpect(model().attribute("totalPages", instanceOf(int.class)))
                .andExpect(model().attribute("totalSpecimens", instanceOf(long.class)));

    }

}
