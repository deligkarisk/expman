package com.arilab.expman.repository.database;

import com.arilab.expman.domain.database.CtScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CtScanRepository extends JpaRepository<CtScan, Long> {

}
