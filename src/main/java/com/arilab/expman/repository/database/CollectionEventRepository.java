package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.CollectionEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionEventRepository extends JpaRepository<CollectionEvent, Long> {

}
