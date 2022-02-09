package com.arilab.expman.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class editSpecimenHTMLTest {

    @Value("${REFERENCE_SPECIMEN_CODE_NULLBASISOFRECORD}")
    private String REFERENCE_SPECIMEN_CODE_NULLBASISOFRECORD;

    @Value("${REFERENCE_SPECIMEN_CODE}")
    private String REFERENCE_SPECIMEN_CODE;

    @Autowired
    private WebApplicationContext wac;


    private WebClient webClient;


    HtmlPage editSpecimenPage;
    HtmlForm form;
    HtmlInput specimenCodeField;
    HtmlInput sampleCodeField;
    HtmlInput collectionEventField;
    HtmlSelect basisOfRecordSelect;
    HtmlInput locatedAtField;
    HtmlInput ownedByField;
    HtmlInput lifestageSexField;
    HtmlInput mediumField;
    HtmlSelect typeStatusField;
    HtmlInput speciesField;
    HtmlInput determinedByField;
    HtmlInput dateIdentifiedField;
    HtmlInput antwebManageField;


    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    @Test
    public void editSpecimenPageWithNullBasisOfRecordWorks() throws IOException {
        HtmlPage editSpecimenPage = webClient.getPage(
                "https://localhost/edit/specimen/" + REFERENCE_SPECIMEN_CODE_NULLBASISOFRECORD);
        assertEquals(200, editSpecimenPage.getWebResponse().getStatusCode());
    }

    @Test
    public void shownFieldsMatchTheModel() throws IOException {

        editSpecimenPage = webClient.getPage("https://localhost/edit/specimen/" + REFERENCE_SPECIMEN_CODE);
        assertEquals(200, editSpecimenPage.getWebResponse().getStatusCode());

        form = editSpecimenPage.getHtmlElementById("editSpecimenForm");
        specimenCodeField = form.getInputByName("specimenCode");
        sampleCodeField = form.getInputByName("sampleCode");
        collectionEventField = form.getInputByName("collectionEvent");
        basisOfRecordSelect = form.getSelectByName("basisOfRecord");
        locatedAtField = form.getInputByName("locatedAt");
        ownedByField = form.getInputByName("ownedBy");
        lifestageSexField = form.getInputByName("lifestageSex");
        mediumField = form.getInputByName("medium");
        typeStatusField = form.getSelectByName("typeStatus");
        speciesField = form.getInputByName("species");
        determinedByField = form.getInputByName("determinedBy");
        dateIdentifiedField = form.getInputByName("dateIdentified");
        antwebManageField = form.getInputByName("antwebManage");

        assertEquals(4, basisOfRecordSelect.getOptionSize());
        assertEquals("CASENT0741227", specimenCodeField.asText());
        assertEquals("PSW15299", sampleCodeField.asText());
        assertEquals("AL0637", collectionEventField.asText());
        assertEquals("Preserved specimen", basisOfRecordSelect.asText());
        assertEquals("", locatedAtField.asText());
        assertEquals("", ownedByField.asText());
        assertEquals("", mediumField.asText());
        assertEquals("Not Provided", typeStatusField.asText());
        assertEquals("Orectognathus.versicolor", speciesField.asText());
        assertEquals("", determinedByField.asText());

    }
}


