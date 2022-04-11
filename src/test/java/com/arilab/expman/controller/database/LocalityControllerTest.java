package com.arilab.expman.controller.database;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.domain.database.supplementary.Country;
import com.arilab.expman.service.database.LocalityService;
import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class LocalityControllerTest {

    @MockBean
    LocalityService localityService;


    @Autowired
    MockMvc mockMvc;

    WebClient webClient;

    @Captor
    ArgumentCaptor<Locality> localityArgumentCaptor;

    @Before
    public void setUpMockito() {
        MockitoAnnotations.initMocks(this);

        webClient = MockMvcWebClientBuilder
                .mockMvcSetup(mockMvc)
                .contextPath("")
                .build();
    }

    @Test
    void submitNewLocalityGetRequest() throws Exception {

        mockMvc.perform(get("/submit/newlocality"))
                .andExpect(status().isOk())
                .andExpect(view().name("layouts/submit/new_locality"))
                .andExpect(model().attribute("newLocality", hasProperty("localityCode", is(nullValue()))));

    }

    @Test
    void submitNewLocalityPostRequestValid() throws Exception {
        mockMvc.perform(post("/submit/newlocality")
                        .param("localityCode", "locality123")
                        .param("country", "Austria")
                        .param("biogeographicRegion", "Africa")
                        .param("adm1", "AdmOne"))
                .andExpect(status().is3xxRedirection());

        then(localityService).should().saveLocality(localityArgumentCaptor.capture());
        assertEquals("locality123", localityArgumentCaptor.getValue().getLocalityCode());
        assertEquals("Austria", localityArgumentCaptor.getValue().getCountry().toString());
        assertEquals("Africa", localityArgumentCaptor.getValue().getBiogeographicRegion().toString());
        assertEquals("AdmOne", localityArgumentCaptor.getValue().getAdm1());

    }


    @Test
    void submitNewLocalityPostRequestInvalid() throws Exception {
        mockMvc.perform(post("/submit/newlocality")
                        .param("country", "RandomCountry")
                        .param("biogeographicRegion", "RandomBiogeographicRegion")
                        .param("adm1", "randomAdm1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeErrorCount("newLocality", 3))
                .andExpect(model().attributeHasFieldErrors("newLocality", "localityCode"))
                .andExpect(model().attributeHasFieldErrors("newLocality", "country"))
                .andExpect(model().attributeHasFieldErrors("newLocality", "biogeographicRegion"))
                .andExpect(view().name("layouts/submit/new_locality"));
    }

    @Test
    void viewLocality() throws Exception {

        Locality returnedLocality = new Locality("locality1234", new Country("CountryCode"
                ,"CountryName", "ISO"));
        when(localityService.findById("locality1234")).thenReturn(Optional.of(returnedLocality));

        mockMvc.perform(get("/view/locality/locality1234"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("locality", returnedLocality));
    }
}