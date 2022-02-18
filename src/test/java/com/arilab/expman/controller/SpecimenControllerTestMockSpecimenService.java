package com.arilab.expman.controller;

import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.service.database.SpecimenService;
import com.arilab.expman.service.database.supplementary.BasisOfRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpecimenControllerTestMockSpecimenService {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    BasisOfRecordService basisOfRecordService;

    @MockBean
    SpecimenService mockSpecimenService;


    @Test
    public void searchSpecimenBySpecimenCodeLike() throws Exception {

        // Dummy list of specimens with 1200 specimens
        Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
        List<Specimen> dummySpecimenList = new ArrayList<>();
        for (int i = 0; i < 1200; i++) {
            dummySpecimenList.add(specimen);
        }

        assert (dummySpecimenList.size() == 1200);

        // given
        given(mockSpecimenService.findBySpecimenCodeContainingIgnoreCase("CASENT")).willReturn(dummySpecimenList);

        List<Specimen> subsetOfSpecimenList = dummySpecimenList.subList(0, 1000);
        assert (subsetOfSpecimenList.size() == 1000);

        this.mockMvc
                .perform(get("/search/specimen/byspecimencode")
                        .param("specimenCode", "CASENT"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/specimens_result"))
                .andExpect(flash().attribute("specimens", subsetOfSpecimenList));
    }
}

