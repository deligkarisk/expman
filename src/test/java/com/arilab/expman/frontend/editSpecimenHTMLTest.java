package com.arilab.expman.frontend;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Genus;
import com.arilab.expman.domain.database.Species;
import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.service.database.SpecimenService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class editSpecimenHTMLTest {

    @Value("${REFERENCE_SPECIMEN_CODE_NULLBASISOFRECORD}")
    private String REFERENCE_SPECIMEN_CODE_NULLBASISOFRECORD;


    @Autowired
    private WebApplicationContext wac;

    @MockBean // use MockBean, not a Mock, as it needs to replace the bean in the application context.
    SpecimenService specimenService;

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

    Specimen specimen;



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
        // given
        CollectionEvent collectionEvent = new CollectionEvent("ColEvent00Y");
        Genus genus = new Genus("GenusY");
        Species species = new Species(genus);
        species.setSpeciesName("SpeciesZ");
        species.setTaxonCode("GenusY.SpeciesZ");
        specimen = new Specimen("TESTCode2893", new TypeStatus("Isotype"));
        specimen.setSpecies(species);
        specimen.setCollectionEvent(collectionEvent);
        specimen.setLifestageSex("lifestageSex3398");
        specimen.setMedium("Water");
        specimen.setDeterminedBy("JohnDoe");
        specimen.setBasisOfRecord(new BasisOfRecord("Pin"));
        when(specimenService.findSingleSpecimenBySpecimenCode("casent000")).thenReturn(Optional.of(specimen));

        // when
        editSpecimenPage = webClient.getPage("https://localhost/edit/specimen/" + "casent000");

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

        // then
        assertEquals(200, editSpecimenPage.getWebResponse().getStatusCode());

        assertEquals(4, basisOfRecordSelect.getOptionSize());
        assertEquals("TESTCode2893", specimenCodeField.asText());
        assertEquals("", sampleCodeField.asText());
        assertEquals("ColEvent00Y", collectionEventField.asText());
        assertEquals("Pin", basisOfRecordSelect.asText());
        assertEquals("", locatedAtField.asText());
        assertEquals("", ownedByField.asText());
        assertEquals("Water", mediumField.asText());
        assertEquals("Isotype", typeStatusField.getSelectedOptions().get(0).asText());
        assertEquals("GenusY.SpeciesZ", speciesField.asText());
        assertEquals("JohnDoe", determinedByField.asText());

    }
}



