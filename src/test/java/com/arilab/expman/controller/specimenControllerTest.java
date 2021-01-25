package com.arilab.expman.controller;

import com.arilab.expman.domain.database.*;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import com.arilab.expman.service.database.SpecimenService;
import com.arilab.expman.service.database.supplementary.BasisOfRecordService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class specimenControllerTest {

    WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BasisOfRecordService basisOfRecordService;

    @MockBean
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



    @Test
    public void editSpecimenTest() throws Exception {

        Specimen testSpecimen = new Specimen();
        Genus genus = new Genus("TestGenus");
        Species species = new Species(genus);
        species.setTaxonCode("TestTaxonCode");
        Locality locality = new Locality();
        locality.setLocalityCode("TestLocalityCode");
        BiogeographicRegion biogeographicRegion = new BiogeographicRegion("TestRegion");
        locality.setBiogeographicRegion(biogeographicRegion);
        CollectionEvent collectionEvent = new CollectionEvent("TestCollectionEventCode",locality);
        BasisOfRecord basisOfRecord = new BasisOfRecord("TestBasisOfRecord");
        testSpecimen.setSpecimenCode("TestCode");
        testSpecimen.setSpecies(species);
        testSpecimen.setCollectionEvent(collectionEvent);
        testSpecimen.setBasisOfRecord(basisOfRecord);


        List<BasisOfRecord> basisOfRecords = new LinkedList<BasisOfRecord>();
        basisOfRecords.add(new BasisOfRecord("TestBasisOfRecord"));
        basisOfRecords.add(new BasisOfRecord("TestBasisOfRecordSecond"));
        basisOfRecords.add(new BasisOfRecord("TestBasisOfRecordThird"));


        when(specimenService.findSingleSpecimenBySpecimenCode("TestTaxonCode")).thenReturn(
                java.util.Optional.of(testSpecimen));
        when(basisOfRecordService.findAll()).thenReturn(basisOfRecords);


        HtmlPage createMsgFormPage = webClient.getPage("https://localhost/edit/specimen/TestTaxonCode");

        HtmlForm form = createMsgFormPage.getHtmlElementById("editSpecimenForm");
        HtmlSelect basisOfRecordSelect = form.getSelectByName("basisOfRecord");
        form.getInputByName("specimenCode");

        // Assert that the shown values on the basis of record are correct
        assertEquals(4,basisOfRecordSelect.getOptionSize());
        assertEquals("TestBasisOfRecord", basisOfRecordSelect.asText());

        // Assert that when changing and submitting new values, the resulting model contains the new values
        basisOfRecordSelect.setSelectedAttribute("TestBasisOfRecordSecond",true);
        HtmlButton submit =form.getButtonByName("submit");
        HtmlPage newPage = submit.click();

        // Verify that newPage message has the new basis of record
        HtmlForm newForm = newPage.getHtmlElementById("editSpecimenForm");
        HtmlSelect newBasisOfRecordSelect = newForm.getSelectByName("basisOfRecord");
        assertEquals("TestBasisOfRecordSecond", newBasisOfRecordSelect.asText());












    }
}
