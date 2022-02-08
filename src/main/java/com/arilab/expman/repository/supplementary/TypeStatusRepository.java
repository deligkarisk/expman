package com.arilab.expman.repository.supplementary;

import com.arilab.expman.domain.supplementary.TypeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeStatusRepository extends JpaRepository<TypeStatus,String> {

    Optional<TypeStatus> findByTypeStatus(String typeStatus);

}
