package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.CollectionEvent;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollectionEventRepository extends JpaRepository<CollectionEvent, String> {

    @EntityGraph(value = "CollectionEvent.Basic", type = EntityGraph.EntityGraphType.FETCH)
    List<CollectionEvent> findAll();

    Optional<CollectionEvent> findByCollectionEventCode(String collectionEventCode);

}
