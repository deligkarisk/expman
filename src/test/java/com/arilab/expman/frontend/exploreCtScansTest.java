package com.arilab.expman.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class exploreCtScansTest {

    String SPECIMEN_CODE_TO_USE = "CASENT0741222";
    String TAXON_CODE = "Novomessor.cockerelli";
    String COLLECTION_EVENT_CODE = "JK00175";
    String FOLDER_LOCATION = "CTScans/Ants/Novomessor/cockerelli/CASENT0741222_Nov_Head_Brain_dissect_2020-01" +
            "-31_142856";
    String SCAN_USER = "julian-katzke";

    @Value("${ENTRIES_PER_PAGE_CT_SCAN_REPOSITORY}")
    int numberOfScansShown;



    @Autowired
    private WebApplicationContext wac;

    private WebClient webClient;


    HtmlPage exploreScansPage;
    HtmlTable exploreScansTable;

    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    @Test
    public void ctscansShownMatchProperValues() throws IOException {


        // when, then
        exploreScansPage = webClient.getPage("https://localhost/explore/ctscans");
        exploreScansTable = exploreScansPage.getHtmlElementById("ctscansTable");
        List<HtmlTableRow> tableContents = exploreScansTable.getRows();

        assertEquals(numberOfScansShown + 1, tableContents.size()); // number of scans + 1 for the headings

        for (int i = 0; i < tableContents.size(); i++) {
            if (tableContents.get(i).getCells().get(0).asText().equals(SPECIMEN_CODE_TO_USE)) {
                String shownTaxonCode = tableContents.get(i).getCells().get(1).asText();
                String shownCollectionEventCode = tableContents.get(i).getCells().get(2).asText();
                String shownScanUser = tableContents.get(i).getCells().get(5).asText();
                String shownFolderLocation =  tableContents.get(i).getCells().get(6).asText();

                assertEquals(TAXON_CODE, shownTaxonCode);
                assertEquals(COLLECTION_EVENT_CODE, shownCollectionEventCode);
                assertEquals(FOLDER_LOCATION, shownFolderLocation);
                assertEquals(SCAN_USER, shownScanUser);
                return;
            }
        }
        // fail if no matching reference value was found
        fail("Could not find proper test case, failing test");
    }
}
