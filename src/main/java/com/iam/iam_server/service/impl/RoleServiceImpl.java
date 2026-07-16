package com.iam.iam_server.service.impl;

import com.iam.iam_server.entity.Permission;
import com.iam.iam_server.entity.Role;
import com.iam.iam_server.repository.PermissionRepository;
import com.iam.iam_server.repository.RoleRepository;
import com.iam.iam_server.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

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

    @Override
    public void assignPermissionToRole(Long roleId, Long permissionId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Permission permission = permissionRepository.findById(permissionId)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        role.getPermissions().add(permission);

        roleRepository.save(role);
    }
}