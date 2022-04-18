package com.arilab.expman.service.database;

import com.arilab.expman.domain.database.CollectionEvent;
import com.arilab.expman.repository.database.CollectionEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionEventService {

    private final CollectionEventRepository collectionEventRepository;

    public CollectionEventService(CollectionEventRepository collectionEventRepository) {
        this.collectionEventRepository = collectionEventRepository;
    }

    public Optional<CollectionEvent> findByCollectionEventCode(String collectionEventCode) {
        return collectionEventRepository.findById(collectionEventCode);
    }


    public List<String> getAllCollectionEventCodes() {
        return collectionEventRepository.getAllCollectionEventCodes();
    }


    public List<String> getMatchingCollectionEventCodes(String matchingCode) {
        return collectionEventRepository.getMatchingEventCodes(matchingCode);
    }

    public CollectionEvent saveCollectionEvent(CollectionEvent collectionEvent) {
        return collectionEventRepository.save(collectionEvent);
    }


}
