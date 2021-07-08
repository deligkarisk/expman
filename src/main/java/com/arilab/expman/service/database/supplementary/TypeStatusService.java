package com.arilab.expman.service.database.supplementary;

import com.arilab.expman.domain.database.supplementary.TypeStatus;
import com.arilab.expman.repository.database.supplementary.TypeStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeStatusService {

    private TypeStatusRepository typeStatusRepository;

    public TypeStatusService(TypeStatusRepository typeStatusRepository) {
        this.typeStatusRepository = typeStatusRepository;
    }

    public List<TypeStatus> findAll() {
        return typeStatusRepository.findAll();
    }
}
