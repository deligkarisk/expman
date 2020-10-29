package com.arilab.expman.service.app;

import com.arilab.expman.domain.app.Role;
import com.arilab.expman.repository.app.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {


    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }


}
