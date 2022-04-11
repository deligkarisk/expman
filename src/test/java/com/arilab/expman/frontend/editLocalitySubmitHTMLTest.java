package com.arilab.expman.frontend;

import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.domain.database.supplementary.BiogeographicRegion;
import com.arilab.expman.domain.database.supplementary.Country;
import com.arilab.expman.service.database.LocalityService;
import com.arilab.expman.service.database.supplementary.BiogeographicRegionService;
import com.arilab.expman.service.database.supplementary.CountryService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
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
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class editLocalitySubmitHTMLTest {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    LocalityService localityService;

    @MockBean
    BiogeographicRegionService biogeographicRegionService;

    @MockBean
    CountryService countryService;

    @Captor
    ArgumentCaptor<Locality> localityArgumentCaptor;


    private WebClient webClient;

    HtmlPage editLocalityPage;
    HtmlForm form;
    HtmlInput localityCodeField;
    HtmlInput countryField;
    HtmlInput adm1Field;
    HtmlInput adm2Field;
    HtmlInput biogeographicRegionField;
    HtmlInput latitudeField;
    HtmlInput accuracyField;
    HtmlButton button;

    @Before
    public void setup() throws IOException {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    @Test
    public void shownFieldsMatchTheModelWithValues() throws IOException {
        // given
        BiogeographicRegion biogeographicRegion = new BiogeographicRegion("biogeo");
        Country country = new Country("CountryCode"
                , "CountryName", "ISO");

        Locality existingLocality = new Locality("locality1234", country );
        existingLocality.setAdm1("preadm1");
        existingLocality.setAdm2("preadm2");
        existingLocality.setBiogeographicRegion(biogeographicRegion);
        when(localityService.findById("locality1234")).thenReturn(Optional.of(existingLocality));
        when(biogeographicRegionService.findById("alteredbiogeo")).thenReturn(Optional.of(new BiogeographicRegion("alteredbiogeo")));
        when(countryService.findByCountryName("CountryName")).thenReturn(Optional.of(country));


        // when
        editLocalityPage = webClient.getPage("https://localhost/edit/locality/locality1234");
        form = editLocalityPage.getHtmlElementById("editLocalityForm");
        localityCodeField = form.getInputByName("localityCode");
        countryField = form.getInputByName("country");
        adm1Field = form.getInputByName("adm1");
        adm2Field = form.getInputByName("adm2");
        biogeographicRegionField = form.getInputByName("biogeographicRegion");
        latitudeField = form.getInputByName("latitude");
        accuracyField = form.getInputByName("accuracy");

        // then
        assertEquals("locality1234", localityCodeField.asText());
        assertEquals("CountryName", countryField.asText());
        assertEquals("preadm1", adm1Field.asText());
        assertEquals("preadm2", adm2Field.asText());
        assertEquals("biogeo", biogeographicRegionField.asText());
        assertEquals("", latitudeField.asText());
        assertEquals("", accuracyField.asText());

        button = form.getButtonByName("submit");

        // modify values
        adm1Field.setValueAttribute("postadm1");
        biogeographicRegionField.setValueAttribute("alteredbiogeo");

        HtmlPage postSubmissionPage = button.click();

        // then assert post-click values
        then(localityService).should().saveLocality(localityArgumentCaptor.capture());
        assertEquals("postadm1", localityArgumentCaptor.getValue().getAdm1());
        assertEquals("alteredbiogeo", localityArgumentCaptor.getValue().getBiogeographicRegion().toString());
        assertEquals("preadm2", localityArgumentCaptor.getValue().getAdm2());
        assertEquals("", latitudeField.asText());
        assertEquals("", accuracyField.asText());
    }



}
