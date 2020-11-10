package com.arilab.expman.domain;

import com.arilab.expman.domain.database.Specimen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpecimenTest {

    private Specimen specimen;

    @Test
    public void requiredArgConstructorTest() {

        specimen = new Specimen("TestSpecimenCode","Lectotype");
        assert specimen.getAntwebManage() == null;
        assert specimen.getBasisOfRecord() == null;
        assert specimen.getSpecimenCode().equals("TestSpecimenCode");
        assert specimen.getTypeStatus().equals("Lectotype");
    }

    @Test
    public void noArgsConstructorTest() {

        specimen = new Specimen();
        specimen.setAntwebManage((short) 1);
        specimen.setBasisOfRecord("Preserved specimen");
        specimen.setLocatedAt("TestLocatedAt");
        specimen.setOwnedBy("TestOwnedBy");
        specimen.setLifestageSex("Worker");
        specimen.setMedium("destroyed");
        specimen.setTypeStatus("Lectotype");
        specimen.setTaxonCode("pheidole.oceanica");
        specimen.setDeterminedBy("F.Hita Garcia");
        specimen.setDateIdentified("2011-03-12");

        assert specimen.getDateIdentified().equals("2011-03-12");
        assert specimen.getAntwebManage().equals((short) 1);
        assert specimen.getEmsCode() == null;
        assert specimen.getEpeCode() == null;

    }


}
