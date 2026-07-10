package com.iam.iam_server.service.impl;

import com.iam.iam_server.entity.Role;
import com.iam.iam_server.repository.RoleRepository;
import com.iam.iam_server.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {

        if (roleRepository.existsByName(role.getName())) {
            throw new RuntimeException("Role already exists");
        }

        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}