package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Genus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenusRepository extends JpaRepository<Genus,Integer> {
}
