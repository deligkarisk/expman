package com.arilab.expman.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
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

@SpringBootTest
@RunWith(SpringRunner.class)
public class editSpecimenHTMLTest {

    @Value("${REFERENCE_SPECIMEN_CODE_NULLBASISOFRECORD}")
    private String REFERENCE_SPECIMEN_CODE;


    @Autowired
    private WebApplicationContext wac;


    private  WebClient webClient;


    @Before
    public void setup() {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(wac).build();
    }

    @Test
    public void editSpecimenPageWithNullBasisOfRecordWorks() throws IOException {
        HtmlPage  editSpecimenPage = webClient.getPage("https://localhost/edit/specimen/" + REFERENCE_SPECIMEN_CODE);
        assertEquals(200, editSpecimenPage.getWebResponse().getStatusCode());
    }




/*


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
*/
}

