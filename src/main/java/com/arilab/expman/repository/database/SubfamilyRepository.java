package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.Subfamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubfamilyRepository extends JpaRepository<Subfamily, Integer> {
}
