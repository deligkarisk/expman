package com.arilab.expman.domain;

import com.arilab.expman.domain.database.Locality;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LocalityTest {

    private Locality locality;


    @Test
    public void requiredArgsConstructorTest() {

        locality = new Locality("LocalityCode", "Argentina");
        assert (locality.getLocalityCode().equals("LocalityCode"));
        assert (locality.getCountry().equals("Argentina"));
        assert (locality.getAccuracy() == null);
    }

    @Test
    public void noArgsConstructorTest() {

        locality = new Locality();
        locality.setLocalityCode("LocalityCode2");
        locality.setCountry("Argentina");
        locality.setAdm1("Adm1");
        locality.setAdm2("Adm2");
        locality.setIsland("TestIsland");
        locality.setIslandGroup("TestIslandGroup");
        locality.setLocalityName("TestLocalityName");
        locality.setLatitude(BigDecimal.valueOf(-33.29966667));
        locality.setLongitude(BigDecimal.valueOf(-171.75974000));
        locality.setLatlongError((float) 0.011);
        locality.setElevation(new BigDecimal(1500));
        locality.setElevationError(new BigDecimal(200));
        locality.setBiogeographicRegion("Palearctic");
        locality.setEmsSite("TestEmsSite");
        locality.setFjSite("TestFJSite");
        locality.setEcologicalCommunityOriginal("TestEcologicalCommunity");
        locality.setEcologicalCommunityStandard("TestEcologicalCommunityStandard");
        locality.setDisturbance((short) 2);
        locality.setAccuracy((short) 2);
        locality.setOtherSite("TestOtherSite");

        assert (locality.getCountry().equals("Argentina"));
        assert (locality.getIsland().equals("TestIsland"));

        // The latitude and longitude values are compared using the String version of the constructor here, versus the
        // .valueOf() constructor in the setter above. This is to ensure the value entered is correct.
        assert (locality.getLatitude().equals(new BigDecimal("-33.29966667")));
        assert (locality.getLongitude().equals(new BigDecimal("-171.75974")));
        assert (locality.getElevation().equals(new BigDecimal("1500")));
        assert (locality.getElevationError().equals(new BigDecimal("200")));

        // The BigDecimal constructors using integer values do not need the string version of the constructor. This
        // is because the unpredictability of the BigDecimal constructor only occurs with doubles, as they cannot
        // always be represented accurately in memory, hence the need for alternative constructors (using String, or
        // .valueOf). But besides this, subsequent entries may utilize double values so we should still the
        // correctness of the constructors.
        assert (locality.getElevation().equals(new BigDecimal(1500)));
        assert (locality.getElevationError().equals(new BigDecimal(200)));

        assert (locality.getLatlongError().equals((float) 0.011));

    }
}
