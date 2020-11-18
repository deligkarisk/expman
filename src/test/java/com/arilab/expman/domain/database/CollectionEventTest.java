package com.arilab.expman.domain.database;


import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Locality;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CollectionEventTest {

    private CollectionEvent collectionEvent;

    @MockBean
    private Locality locality;

    @Test
    public void noArgsConstructor() {
        collectionEvent = new CollectionEvent();
        collectionEvent.setCollectionEventCode("TestCollectionEventCode");
        collectionEvent.setCollectedBy("TestCollectedBy");
        collectionEvent.setMethod("TestMethod");
        collectionEvent.setSamplingEffort("TestSamplingEffort");
        collectionEvent.setDateCollectedStart("2009-09-11");
        collectionEvent.setDateCollectedEnd("2009-10-10");
        collectionEvent.setDateFlag((3));
    }


    @Test
    public void requiredArgsConstructor() {
        collectionEvent = new CollectionEvent("TestCollectionEventCode",locality);
    }


}
