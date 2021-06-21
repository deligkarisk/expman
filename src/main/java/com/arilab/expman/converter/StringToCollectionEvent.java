package com.arilab.expman.converter;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.service.database.CollectionEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StringToCollectionEvent implements Converter<String, CollectionEvent> {


    @Autowired
    CollectionEventService collectionEventService;

    @Override
    public CollectionEvent convert(String collectionEventCode) {

        if (collectionEventCode == "") { return null;}

        Optional<CollectionEvent> optionalCollectionEvent =
                collectionEventService.findByCollectionEventCode(collectionEventCode);
        if (optionalCollectionEvent.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return optionalCollectionEvent.get();

    }
}
