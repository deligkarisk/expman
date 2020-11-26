package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.CollectionEvent;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionEventRepository extends JpaRepository<CollectionEvent, Long> {

    @EntityGraph(value = "CollectionEvent.Basic", type = EntityGraph.EntityGraphType.FETCH)
    List<CollectionEvent> findAll();

}
