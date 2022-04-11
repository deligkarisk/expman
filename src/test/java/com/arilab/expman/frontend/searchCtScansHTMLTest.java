package com.arilab.expman.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class searchCtScansHTMLTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    private WebApplicationContext wac;

    private WebClient webClient;

    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }


    //TODO: Waiting for HtmlUnit to be fixed, as this raises an exception due to incompatibilities with JS.
    @Test
    public void testResultsShown() throws IOException {
/*
        WebRequest webRequest = new WebRequest(new URL("https://localhost/search/ctscan/byspecimencode"));
        List<NameValuePair> requestParameters = new ArrayList<>();
        requestParameters.add(new NameValuePair("specimenCode", "casent"));
        webRequest.setRequestParameters(requestParameters);

        HtmlPage htmlPage = webClient.getPage("requestTopage");
        HtmlTable htmlTable = htmlPage.getHtmlElementById("ctScansTable");
        List<HtmlTableRow> tableContents = htmlTable.getRows();
        assertEquals(11, tableContents.size());*/


        return;

    }
}
