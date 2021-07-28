package com.arilab.expman.converter;

import com.arilab.expman.domain.database.CollectionEvent;
import org.springframework.core.convert.converter.Converter;

public class CollectionEventToString implements Converter<CollectionEvent, String> {


    @Override
    public String convert(CollectionEvent collectionEvent) {
        return collectionEvent.toString();
    }
}
