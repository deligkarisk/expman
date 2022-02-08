package com.arilab.expman.repository.supplementary;

import com.arilab.expman.domain.supplementary.BasisOfRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasisOfRecordRepository extends JpaRepository<BasisOfRecord, String> {

    Optional<BasisOfRecord> findByBasisOfRecord(String basisOfRecord);

}
