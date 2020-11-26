package com.arilab.expman.repository.database.supplementary;

import com.arilab.expman.domain.database.supplementary.TypeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeStatusRepository extends JpaRepository<TypeStatus,String> {

    Optional<TypeStatus> findByTypeStatus(String typeStatus);

}
