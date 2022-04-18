package com.arilab.expman.frontend;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.service.database.CollectionEventService;
import com.arilab.expman.service.database.LocalityService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;

@SpringBootTest
@RunWith(SpringRunner.class)
public class newCompoundCollectionEventHTMLTest {

    @Autowired
    private WebApplicationContext wac;

    private WebClient webClient;

    @MockBean
    LocalityService localityService;

    @MockBean
    CollectionEventService collectionEventService;

    @Captor
    ArgumentCaptor<Locality> localityArgumentCaptor;

    @Captor
    ArgumentCaptor<CollectionEvent> collectionEventArgumentCaptor;

    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    HtmlPage mainPage;
    HtmlForm mainForm;
    HtmlListItem collectionEventTab;
    HtmlListItem localityTab;
    HtmlUnorderedList htmlList;

    HtmlInput localityCodeField;
    HtmlInput countryField;
    HtmlInput adm1Field;
    HtmlInput adm2Field;
    HtmlInput biogeographicRegionField;
    HtmlInput latitudeField;
    HtmlInput accuracyField;

    HtmlInput collectionEventCodeField;
    HtmlInput localityField;
    HtmlInput collectedByField;
    HtmlInput methodField;
    HtmlInput samplingErrorField;
    HtmlInput dateCollectedStartField;
    HtmlInput getDateCollectedEndField;
    HtmlInput behaviorField;


    HtmlButton button;




    @Test
    public void correctSubmissionGoesThrough() throws IOException {
        // given


        // when
        mainPage = webClient.getPage("https://localhost/submit/newcollectionevent");

        // then, all fields from both collection event and locality exist
        mainForm = mainPage.getHtmlElementById("submitCompoundCollectionEventForm");
        htmlList = mainPage.getHtmlElementById("tab");
        collectionEventTab = mainPage.getHtmlElementById("collection_event_list_item");
        localityCodeField = mainPage.getHtmlElementById("localityCode");
        countryField = mainPage.getHtmlElementById("country");
        adm1Field = mainPage.getHtmlElementById("adm1");
        adm2Field = mainPage.getHtmlElementById("adm2");
        biogeographicRegionField = mainPage.getHtmlElementById("biogeographicRegion");
        latitudeField = mainPage.getHtmlElementById("latitude");
        accuracyField = mainPage.getHtmlElementById("accuracy");
        collectionEventCodeField = mainPage.getHtmlElementById("collectionEvent");
        localityField = mainPage.getHtmlElementById("locality");
        collectedByField = mainPage.getHtmlElementById("collectedBy");
        methodField = mainPage.getHtmlElementById("method");
        samplingErrorField = mainPage.getHtmlElementById("samplingEffort");
        dateCollectedStartField = mainPage.getHtmlElementById("dateCollectedStart");
        getDateCollectedEndField = mainPage.getHtmlElementById("dateCollectedEnd");
        behaviorField = mainPage.getHtmlElementById("behavior");

        button = mainForm.getButtonByName("submit");

        collectionEventCodeField.setValueAttribute("collection_event_001");
        localityField.setValueAttribute("New Locality");
        localityCodeField.setValueAttribute("LocalityX001");

        HtmlPage postSubmissionPage = button.click();

        then(localityService).should().saveLocality(localityArgumentCaptor.capture());
        then(collectionEventService).should().saveCollectionEvent(collectionEventArgumentCaptor.capture());
        assertEquals("collection_event_001", collectionEventArgumentCaptor.getValue().getCollectionEventCode());
        assertEquals("LocalityX001", localityArgumentCaptor.getValue().getLocalityCode());



    }






}
