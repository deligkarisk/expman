package com.arilab.expman.frontend;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Genus;
import com.arilab.expman.domain.database.Species;
import com.arilab.expman.domain.database.Specimen;
import com.arilab.expman.domain.database.supplementary.BasisOfRecord;
import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.service.database.SpecimenService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class viewSpecimenHTMLTest {

    @Autowired
    private WebApplicationContext wac;

    private WebClient webClient;

    HtmlPage viewSpecimenPage;
    HtmlTable htmlTable;

    Specimen specimen;

    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    @MockBean // use MockBean, not a Mock, as it needs to replace the bean in the application context.
    SpecimenService specimenService;



    @Test
    public void shownFieldsMatchTheModelWithValues() throws IOException {
        // given
        CollectionEvent collectionEvent = new CollectionEvent("ColEvent00X");
        Genus genus = new Genus("GenusX");
        Species species = new Species(genus);
        species.setSpeciesName("SpeciesY");
        species.setTaxonCode("GenusX.SpeciesY");
        specimen = new Specimen("TESTCode0001", new TypeStatus("Isotype"));
        specimen.setSpecies(species);
        specimen.setCollectionEvent(collectionEvent);
        specimen.setLifestageSex("lifestageSex001");
        specimen.setMedium("stringMedium");
        specimen.setDeterminedBy("stringDeterminedBy");
        specimen.setLocatedAt("Athens");
        specimen.setOwnedBy("King");
        specimen.setBasisOfRecord(new BasisOfRecord("Pin"));
        specimen.setSampleCode("000999");
        specimen.setDateIdentified("20220202");
        when(specimenService.findSingleSpecimenBySpecimenCode("casent000")).thenReturn(Optional.of(specimen));


        // when
        viewSpecimenPage = webClient.getPage("https://localhost/view/specimen/" + "casent000");
        htmlTable = viewSpecimenPage.getHtmlElementById("specimenDataTable");
        List<HtmlTableRow> tableContents = htmlTable.getRows();
        String shownSpecimenCode = tableContents.get(0).getCells().get(1).asText(); // First row on the table is
        // specimen, with the first element the heading, and the second element the value. (See the html page for
        // details).
        String shownSampleCode = tableContents.get(1).getCells().get(1).asText();
        String shownCollectionEvent = tableContents.get(2).getCells().get(1).asText();
        String shownBasisOfRecord = tableContents.get(3).getCells().get(1).asText();
        String shownLocatedAt = tableContents.get(4).getCells().get(1).asText();
        String shownOwnedBy = tableContents.get(5).getCells().get(1).asText();
        String shownLifestageSex = tableContents.get(6).getCells().get(1).asText();
        String shownMedium = tableContents.get(7).getCells().get(1).asText();
        String shownTypeStatus = tableContents.get(8).getCells().get(1).asText();
        String shownSpecies = tableContents.get(9).getCells().get(1).asText();
        String shownDeterminedBy = tableContents.get(10).getCells().get(1).asText();
        String shownDateIdentified = tableContents.get(11).getCells().get(1).asText();


        // then
        assertEquals(200, viewSpecimenPage.getWebResponse().getStatusCode());
        assertEquals(shownSpecimenCode, "TESTCode0001");
        assertEquals(shownSampleCode, "000999");
        assertEquals(shownCollectionEvent, "ColEvent00X");
        assertEquals(shownBasisOfRecord,"Pin");
        assertEquals(shownLocatedAt,"Athens");
        assertEquals(shownOwnedBy,"King");
        assertEquals(shownLifestageSex,"lifestageSex001");
        assertEquals(shownMedium,"stringMedium");
        assertEquals(shownTypeStatus, "Isotype");
        assertEquals(shownSpecies,"GenusX.SpeciesY");
        assertEquals(shownDeterminedBy, "stringDeterminedBy");
        assertEquals(shownDateIdentified,"20220202");

    }


    @Test
    public void shownFieldsMatchTheModelWithEmptyFields() throws IOException {
        // given
        CollectionEvent collectionEvent = new CollectionEvent("ColEvent00X");
        specimen = new Specimen("TESTCode0002", new TypeStatus("Isotype"));
        when(specimenService.findSingleSpecimenBySpecimenCode("casent000")).thenReturn(Optional.of(specimen));


        // when
        viewSpecimenPage = webClient.getPage("https://localhost/view/specimen/" + "casent000");
        htmlTable = viewSpecimenPage.getHtmlElementById("specimenDataTable");
        List<HtmlTableRow> tableContents = htmlTable.getRows();
        String shownSpecimenCode = tableContents.get(0).getCells().get(1).asText(); // First row on the table is
        // specimen, with the first element the heading, and the second element the value. (See the html page for
        // details).
        String shownSampleCode = tableContents.get(1).getCells().get(1).asText();
        String shownCollectionEvent = tableContents.get(2).getCells().get(1).asText();
        String shownBasisOfRecord = tableContents.get(3).getCells().get(1).asText();
        String shownLocatedAt = tableContents.get(4).getCells().get(1).asText();
        String shownOwnedBy = tableContents.get(5).getCells().get(1).asText();
        String shownLifestageSex = tableContents.get(6).getCells().get(1).asText();
        String shownMedium = tableContents.get(7).getCells().get(1).asText();
        String shownTypeStatus = tableContents.get(8).getCells().get(1).asText();
        String shownSpecies = tableContents.get(9).getCells().get(1).asText();
        String shownDeterminedBy = tableContents.get(10).getCells().get(1).asText();
        String shownDateIdentified = tableContents.get(11).getCells().get(1).asText();


        // then
        assertEquals(200, viewSpecimenPage.getWebResponse().getStatusCode());
        assertEquals(shownSpecimenCode, "TESTCode0002");
        assertEquals(shownSampleCode, "");
        assertEquals(shownCollectionEvent, "");
        assertEquals(shownBasisOfRecord,"");
        assertEquals(shownLocatedAt,"");
        assertEquals(shownOwnedBy,"");
        assertEquals(shownLifestageSex,"");
        assertEquals(shownMedium,"");
        assertEquals(shownTypeStatus, "Isotype");
        assertEquals(shownSpecies,"");
        assertEquals(shownDeterminedBy, "");
        assertEquals(shownDateIdentified,"");
    }

}
