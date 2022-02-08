package com.arilab.expman.service.supplementary;

import com.arilab.expman.domain.supplementary.TypeStatus;
import com.arilab.expman.repository.supplementary.TypeStatusRepository;
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
