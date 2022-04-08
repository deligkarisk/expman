package com.arilab.expman.controller;

import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.service.database.CtScanService;
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


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CtScanControllerCtScanSearchTest {

    int overflowLimit = 1000;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CtScanService ctScanService;

    @Test
    public void searchCtScansBySpecimenCodeWhenResultsOverflow() throws Exception {
        // given
        int returnListLength = overflowLimit + 1;

        List<CtScan> ctScans = new ArrayList<>();
        for (int i = 0; i < returnListLength; i++) {
            CtScan ctScan = new CtScan();
            ctScans.add(ctScan);
        }

        assert (ctScans.size() == returnListLength);

        given(ctScanService.findBySpecimenCodeContainingIgnoreCase("CASENT")).willReturn(ctScans);

        List<CtScan> subsetOfCtScansList = ctScans.subList(0, overflowLimit); // what should be returned, after
        // limiting the results (in the controller)

        // when
        this.mockMvc
                .perform(get("/search/ctscan/byspecimencode")
                        .param("specimenCode", "CASENT"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/ctscans_result"))
                .andExpect(flash().attribute("ctScans", subsetOfCtScansList))
                .andExpect(flash().attribute("dataLimitExceeded", true));
    }

    @Test
    public void searchCtScansBySpecimenCodeWhenResultsDoNotOverflow() throws Exception {
        // given
        int returnListLength = overflowLimit; // results do not overflow when the size is equal to the overflow limit.

        List<CtScan> ctScans = new ArrayList<>();
        for (int i = 0; i < returnListLength; i++) {
            CtScan ctScan = new CtScan();
            ctScans.add(ctScan);
        }

        assert (ctScans.size() == returnListLength);

        given(ctScanService.findBySpecimenCodeContainingIgnoreCase("CASENT")).willReturn(ctScans);

        // when
        this.mockMvc
                .perform(get("/search/ctscan/byspecimencode")
                        .param("specimenCode", "CASENT"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/ctscans_result"))
                .andExpect(flash().attribute("ctScans", ctScans))
                .andExpect(flash().attribute("dataLimitExceeded", false));
    }

    @Test
    public void searchCtScansByLocalityCodeWhenResultsOverflow() throws Exception {
        // given
        int returnListLength = overflowLimit + 1;

        List<CtScan> ctScans = new ArrayList<>();
        for (int i = 0; i < returnListLength; i++) {
            CtScan ctScan = new CtScan();
            ctScans.add(ctScan);
        }

        assert (ctScans.size() == returnListLength);

        given(ctScanService.findByLocalityCodeContainingIgnoreCase("Locality")).willReturn(ctScans);

        List<CtScan> subsetOfCtScansList = ctScans.subList(0, overflowLimit); // what should be returned, after
        // limiting the results (in the controller)

        // when
        this.mockMvc
                .perform(get("/search/ctscan/bylocalitycode")
                        .param("localityCode", "Locality"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/ctscans_result"))
                .andExpect(flash().attribute("ctScans", subsetOfCtScansList))
                .andExpect(flash().attribute("dataLimitExceeded", true));
    }

    @Test
    public void searchCtScansByLocalityCodeWhenResultsDoNotOverflow() throws Exception {
        // given
        int returnListLength = overflowLimit; // results do not overflow when the size is equal to the overflow limit.

        List<CtScan> ctScans = new ArrayList<>();
        for (int i = 0; i < returnListLength; i++) {
            CtScan ctScan = new CtScan();
            ctScans.add(ctScan);
        }

        assert (ctScans.size() == returnListLength);

        given(ctScanService.findByLocalityCodeContainingIgnoreCase("Locality")).willReturn(ctScans);

        // when
        this.mockMvc
                .perform(get("/search/ctscan/bylocalitycode")
                        .param("localityCode", "Locality"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/ctscans_result"))
                .andExpect(flash().attribute("ctScans", ctScans))
                .andExpect(flash().attribute("dataLimitExceeded", false));
    }

    @Test
    public void searchCtScansByTaxonCodeWhenResultsOverflow() throws Exception {
        // given
        int returnListLength = overflowLimit + 1;

        List<CtScan> ctScans = new ArrayList<>();
        for (int i = 0; i < returnListLength; i++) {
            CtScan ctScan = new CtScan();
            ctScans.add(ctScan);
        }

        assert (ctScans.size() == returnListLength);

        given(ctScanService.findByTaxonCodeContainingIgnoreCase("species")).willReturn(ctScans);

        List<CtScan> subsetOfCtScansList = ctScans.subList(0, overflowLimit); // what should be returned, after
        // limiting the results (in the controller)

        // when
        this.mockMvc
                .perform(get("/search/ctscan/bytaxoncode")
                        .param("taxonCode", "species"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/ctscans_result"))
                .andExpect(flash().attribute("ctScans", subsetOfCtScansList))
                .andExpect(flash().attribute("dataLimitExceeded", true));
    }

    @Test
    public void searchCtScansByTaxonCodeWhenResultsDoNotOverflow() throws Exception {
        // given
        int returnListLength = overflowLimit; // results do not overflow when the size is equal to the overflow limit.

        List<CtScan> ctScans = new ArrayList<>();
        for (int i = 0; i < returnListLength; i++) {
            CtScan ctScan = new CtScan();
            ctScans.add(ctScan);
        }

        assert (ctScans.size() == returnListLength);

        given(ctScanService.findByTaxonCodeContainingIgnoreCase("species")).willReturn(ctScans);

        // when
        this.mockMvc
                .perform(get("/search/ctscan/bytaxoncode")
                        .param("taxonCode", "species"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/search_result/ctscans_result"))
                .andExpect(flash().attribute("ctScans", ctScans))
                .andExpect(flash().attribute("dataLimitExceeded", false));
    }



}
