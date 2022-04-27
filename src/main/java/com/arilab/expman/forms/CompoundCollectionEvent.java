package com.arilab.expman.forms;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Locality;
import com.arilab.expman.domain.database.validator.LocalityCodeIsNewCheck;
import com.arilab.expman.forms.validator.CompoundCollectionEventLocality;
import lombok.Data;

@Data
@CompoundCollectionEventLocality
@LocalityCodeIsNewCheck
public class CompoundCollectionEvent {

    private CollectionEvent collectionEvent;
    private Locality locality;

    public CompoundCollectionEvent() {
        collectionEvent = new CollectionEvent();
        locality = new Locality();
    }

    public Locality getLocality() {
        return locality;
    }
}
