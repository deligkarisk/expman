package com.arilab.expman.forms;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.domain.database.Locality;
import lombok.Data;

@Data
public class CompoundCollectionEvent {

    private CollectionEvent collectionEvent;
    private Locality locality;
}
