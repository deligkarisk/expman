package com.arilab.expman.service;

import com.arilab.expman.domain.CollectionEvent;
import com.arilab.expman.repository.CollectionEventRepository;
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

}
