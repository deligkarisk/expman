package com.arilab.expman.converter;

import com.arilab.expman.domain.database.CollectionEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StringToCollectionEventTest {

    @Value("${REFERENCE_COLLECTION_EVENT_CODE}")
    String REFERENCE_COLLECTION_EVENT_CODE;

    @Value("${REFERENCE_COLLECTION_EVENT_LOCALITY_CODE}")
    String REFERENCE_COLLECTION_EVENT_LOCALITY_CODE;


    @Autowired
    StringToCollectionEvent stringToCollectionEvent;

    @Test(expected = IllegalArgumentException.class)
    public void testNullParameter() throws Exception {
        stringToCollectionEvent.convert(null);
    }

    @Test
    public void testEmptyString() throws Exception {
        assertNull(stringToCollectionEvent.convert(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCollectionEvent() throws Exception {
        stringToCollectionEvent.convert("InvalidCollectionEventCode");
    }

    @Test
    public void testExistingCollectionEvent() throws Exception {
        CollectionEvent collectionEvent = stringToCollectionEvent.convert(REFERENCE_COLLECTION_EVENT_CODE);
        assertEquals(REFERENCE_COLLECTION_EVENT_LOCALITY_CODE, collectionEvent.getLocality().getLocalityCode());
    }
}
