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
public class SpecimenControllerSpecimenSearchTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    BasisOfRecordService basisOfRecordService;

    @MockBean
    SpecimenService mockSpecimenService;

    int overflowLimit = 1000; // hard-coded limit for when a subset of the returned results will be shown.


    // Test for specimen search when results returned are more than the limit.
    @Test
    public void searchSpecimenBySpecimenCodeLikeWhenResultsOverflow() throws Exception {

        // Dummy list of specimens
        Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
        List<Specimen> dummySpecimenList = new ArrayList<>();
        int returnListLength = overflowLimit + 1;
        for (int i = 0; i < returnListLength; i++) {
            dummySpecimenList.add(specimen);
        }

        assert (dummySpecimenList.size() == returnListLength);

        // given
        given(mockSpecimenService.findBySpecimenCodeContainingIgnoreCase("CASENT")).willReturn(dummySpecimenList);

        List<Specimen> subsetOfSpecimenList = dummySpecimenList.subList(0, overflowLimit);
        assert (subsetOfSpecimenList.size() == overflowLimit);

        this.mockMvc
                .perform(get("/search/specimen/byspecimencode")
                        .param("specimenCode", "CASENT"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/specimens_result"))
                .andExpect(flash().attribute("specimens", subsetOfSpecimenList))
                .andExpect(flash().attribute("dataLimitExceeded", true));
    }


// Test for specimen search when results returned are less than the limit.
@Test
public void searchSpecimenBySpecimenCodeLikeWhenResultsDoNotOverflow() throws Exception {

    // Dummy list of specimens
    Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
    List<Specimen> dummySpecimenList = new ArrayList<>();
    int returnListLength = overflowLimit; // Results should not be limited when having a returned list with a size
    // equal to the overflowLimit, only when they size of the results exceed the limit should results be limited.
    for (int i = 0; i < returnListLength; i++) {
        dummySpecimenList.add(specimen);
    }

    assert (dummySpecimenList.size() == returnListLength);

    // given
    given(mockSpecimenService.findBySpecimenCodeContainingIgnoreCase("CASENT")).willReturn(dummySpecimenList);

    this.mockMvc
            .perform(get("/search/specimen/byspecimencode")
                    .param("specimenCode", "CASENT"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/search_result/specimens_result"))
            .andExpect(flash().attribute("specimens", dummySpecimenList))
            .andExpect(flash().attribute("dataLimitExceeded", false));
}


    @Test
    public void searchSpecimenByLocalityCodeLikeWhenResultsOverflow() throws Exception {

        // Dummy list of specimens
        Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
        List<Specimen> dummySpecimenList = new ArrayList<>();
        int returnListLength = overflowLimit + 1;
        for (int i = 0; i < returnListLength; i++) {
            dummySpecimenList.add(specimen);
        }

        assert (dummySpecimenList.size() == returnListLength);

        // given
        given(mockSpecimenService.findByLocalityCodeContainingIgnoreCase("Golf")).willReturn(dummySpecimenList);

        List<Specimen> subsetOfSpecimenList = dummySpecimenList.subList(0, overflowLimit);
        assert (subsetOfSpecimenList.size() == overflowLimit);

        this.mockMvc
                .perform(get("/search/specimen/bylocalitycode")
                        .param("localityCode", "Golf"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/specimens_result"))
                .andExpect(flash().attribute("specimens", subsetOfSpecimenList))
                .andExpect(flash().attribute("dataLimitExceeded", true));
    }


    @Test
    public void searchSpecimenByLocalityCodeLikeWhenResultsDoNotOverflow() throws Exception {

        // Dummy list of specimens
        Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
        List<Specimen> dummySpecimenList = new ArrayList<>();
        int returnListLength = overflowLimit; // Results should not be limited when having a returned list with a size
        // equal to the overflowLimit, only when they size of the results exceed the limit should results be limited.
        for (int i = 0; i < returnListLength; i++) {
            dummySpecimenList.add(specimen);
        }

        assert (dummySpecimenList.size() == returnListLength);

        // given
        given(mockSpecimenService.findByLocalityCodeContainingIgnoreCase("Golf")).willReturn(dummySpecimenList);

        this.mockMvc
                .perform(get("/search/specimen/bylocalitycode")
                        .param("localityCode", "Golf"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/specimens_result"))
                .andExpect(flash().attribute("specimens", dummySpecimenList))
                .andExpect(flash().attribute("dataLimitExceeded", false));
    }



    @Test
    public void searchSpecimenByTaxonCodeLikeWhenResultsOverflow() throws Exception {

        // Dummy list of specimens
        Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
        List<Specimen> dummySpecimenList = new ArrayList<>();
        int returnListLength = overflowLimit + 1;
        for (int i = 0; i < returnListLength; i++) {
            dummySpecimenList.add(specimen);
        }

        assert (dummySpecimenList.size() == returnListLength);

        // given
        given(mockSpecimenService.findByTaxonCodeContainingIgnoreCase("TaxonCode")).willReturn(dummySpecimenList);

        List<Specimen> subsetOfSpecimenList = dummySpecimenList.subList(0, overflowLimit);
        assert (subsetOfSpecimenList.size() == overflowLimit);

        this.mockMvc
                .perform(get("/search/specimen/bytaxoncode")
                        .param("taxonCode", "TaxonCode"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/specimens_result"))
                .andExpect(flash().attribute("specimens", subsetOfSpecimenList))
                .andExpect(flash().attribute("dataLimitExceeded", true));
    }


    @Test
    public void searchSpecimenByTaxonCodeLikeWhenResultsDoNotOverflow() throws Exception {

        // Dummy list of specimens
        Specimen specimen = new Specimen("TESTCODE", new TypeStatus());
        List<Specimen> dummySpecimenList = new ArrayList<>();
        int returnListLength = overflowLimit; // Results should not be limited when having a returned list with a size
        // equal to the overflowLimit, only when they size of the results exceed the limit should results be limited.
        for (int i = 0; i < returnListLength; i++) {
            dummySpecimenList.add(specimen);
        }

        assert (dummySpecimenList.size() == returnListLength);

        // given
        given(mockSpecimenService.findByTaxonCodeContainingIgnoreCase("TaxonCode")).willReturn(dummySpecimenList);

        this.mockMvc
                .perform(get("/search/specimen/bytaxoncode")
                        .param("taxonCode", "TaxonCode"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/specimens_result"))
                .andExpect(flash().attribute("specimens", dummySpecimenList))
                .andExpect(flash().attribute("dataLimitExceeded", false));
    }




}

