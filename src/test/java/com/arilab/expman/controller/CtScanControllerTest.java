package com.arilab.expman.controller;


import com.arilab.expman.domain.database.CtScan;
import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.service.database.CtScanService;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CtScanControllerTest {

    @Autowired
    MockMvc mockMvc;

    @SpyBean
    private CtScanService ctScanServiceMock;



    WebClient webClient;


    @Before
    public void setUpMockito() {
        MockitoAnnotations.initMocks(this);

        webClient = MockMvcWebClientBuilder
                .mockMvcSetup(mockMvc)
                .contextPath("")
                .build();
    }

    @Test
    public void viewScanTest() throws Exception {

        Specimen specimen = new Specimen("CASENTTEST", new TypeStatus());
        CtScan ctScan = new CtScan(specimen, "99%", "wetField", "scan-user", "No");
        Optional<CtScan> optionalCtScan = Optional.of(ctScan);

        when(ctScanServiceMock.findById(Long.valueOf(1))).thenReturn(optionalCtScan);
        when(ctScanServiceMock.findById(Long.valueOf(2))).thenReturn(Optional.empty());


        mockMvc.perform(get("/view/ctscan/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("layouts/view/ctscan"))
                .andExpect(model().attribute("ctscan", hasProperty("wet", is("wetField"))));


        mockMvc.perform(get("/view/ctscan/2"))
                .andExpect(status().isOk())
                .andExpect(view().name("layouts/does_not_exist"));

        verify(ctScanServiceMock, times(1)).findById(Long.valueOf(1));
        verify(ctScanServiceMock, times(1)).findById(Long.valueOf(2));

    }

    @Test
    public void exploreCtscansTest() throws Exception {

        // when
        when(ctScanServiceMock.findAll()).thenCallRealMethod();
        when(ctScanServiceMock.findAll(1)).thenCallRealMethod();

        Integer PAGE_SIZE = 10;


        mockMvc.perform(get("/explore/ctscans")).andExpect(status().isOk())
                .andExpect(view().name("layouts/explore/ctscans"))
                .andExpect(model().attribute("ctscans", instanceOf(List.class)))
                .andExpect(model().attribute("ctscans", hasSize(PAGE_SIZE)))
                .andExpect(model().attribute("currentPage", instanceOf(int.class)))
                .andExpect(model().attribute("totalPages", instanceOf(int.class)))
                .andExpect(model().attribute("totalCtscans", instanceOf(long.class)));

        mockMvc.perform(get("/explore/ctscans/page/1")).andExpect(status().isOk())
                .andExpect(view().name("layouts/explore/ctscans"))
                .andExpect(model().attribute("ctscans", instanceOf(List.class)))
                .andExpect(model().attribute("ctscans", hasSize(PAGE_SIZE)))
                .andExpect(model().attribute("currentPage", instanceOf(int.class)))
                .andExpect(model().attribute("totalPages", instanceOf(int.class)))
                .andExpect(model().attribute("totalCtscans", instanceOf(long.class)));

    }


}
