package com.arilab.expman.frontend;

import com.arilab.expman.converter.StringToCollectionEvent;
import com.arilab.expman.converter.StringToSpecies;
import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Genus;
import com.arilab.expman.domain.database.Species;
import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.service.database.SpecimenService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class editSpecimenSubmitHTMLTest {

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

    Specimen specimen;

    @MockBean
    SpecimenService specimenService;

    @MockBean
    StringToSpecies stringToSpecies;

    @MockBean
    StringToCollectionEvent stringToCollectionEvent;

    @Captor
    private ArgumentCaptor<Specimen> captor;

    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();

        setUpSpecimenBeforeChange();
    }



    @Test
    public void submitSpecimenWithChangedFieldsCallsCorrectMethodAndArguments() throws IOException {
        // given
        when(specimenService.findSingleSpecimenBySpecimenCode("TESTCode00001")).thenReturn(Optional.of(specimen));
        when(specimenService.saveSpecimen(specimen)).thenReturn(specimen);

        Species species = new Species(new Genus("Pheidole"));
        species.setTaxonCode("Pheidole.braveheart");
        CollectionEvent newCollectionEvent = new CollectionEvent("Amazonia2022");

        when(stringToCollectionEvent.convert("Amazonia2022")).thenReturn(newCollectionEvent); // need this for
        // conversion from string to collection event during form "submission", otherwise an error is thrown as there
        // is no such collection event
        when(stringToSpecies.convert("Pheidole.braveheart")).thenReturn(species); // similar to the collection event
        // above

        // when
        editSpecimenPage = webClient.getPage("https://localhost/edit/specimen/" + "TESTCode00001");
        form = editSpecimenPage.getHtmlElementById("editSpecimenForm");
        HtmlButton submitInput =  form.getButtonByName("submit");

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

        // modify the values of the specimen through the form
        sampleCodeField.setValueAttribute("2220202");
        collectionEventField.setValueAttribute("Amazonia2022");
        basisOfRecordSelect.setSelectedAttribute("Preserved specimen",true);
        locatedAtField.setValueAttribute("Airport");
        lifestageSexField.setValueAttribute("33worker");
        typeStatusField.setSelectedAttribute("Syntype",true);
        speciesField.setValueAttribute("Pheidole.braveheart");
        determinedByField.setValueAttribute("Yoshimitsu");

        HtmlPage postSubmissionPage = submitInput.click();


        // then

        // saveSpecimen is called with the correct (new arguments)
        verify(specimenService, times(1)).saveSpecimen(captor.capture());
        assertEquals("TESTCode00001", captor.getValue().getSpecimenCode());
        assertEquals("2220202", captor.getValue().getSampleCode());
        assertEquals(newCollectionEvent, captor.getValue().getCollectionEvent());
        assertEquals("Preserved specimen", captor.getValue().getBasisOfRecord().getBasisOfRecord());
        assertEquals("Airport", captor.getValue().getLocatedAt());
        assertEquals("33worker", captor.getValue().getLifestageSex());
        assertEquals("Syntype", captor.getValue().getTypeStatus().getTypeStatus());
        assertEquals("Pheidole.braveheart", captor.getValue().getSpecies().getTaxonCode());
        assertEquals("Yoshimitsu", captor.getValue().getDeterminedBy());

        // assert that non-modified fields still have the old values
        assertEquals(captor.getValue().getMedium(), "Water");
        assertEquals((short) 1, captor.getValue().getAntwebManage());




    }


    private void setUpSpecimenBeforeChange() {
        CollectionEvent collectionEvent = new CollectionEvent("ColEvent00Y");
        Genus genus = new Genus("GenusY");
        Species species = new Species(genus);
        species.setSpeciesName("SpeciesZ");
        species.setTaxonCode("GenusY.SpeciesZ");
        specimen = new Specimen("TESTCode00001", new TypeStatus("Isotype"));
        specimen.setSpecies(species);
        specimen.setCollectionEvent(collectionEvent);
        specimen.setLifestageSex("lifestageSex3398");
        specimen.setMedium("Water");
        specimen.setSampleCode("1110101");
        specimen.setDeterminedBy("JohnDoe");
        specimen.setBasisOfRecord(new BasisOfRecord("Pin"));
        specimen.setLocatedAt("Thessaloniki");
        specimen.setOwnedBy("Jin Kazama");
        specimen.setAntwebManage((short) 1);
    }
}
