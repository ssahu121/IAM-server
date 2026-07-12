package com.iam.iam_server.service.impl;

import com.iam.iam_server.dto.PermissionRequest;
import com.iam.iam_server.dto.PermissionResponse;
import com.iam.iam_server.entity.Permission;
import com.iam.iam_server.repository.PermissionRepository;
import com.iam.iam_server.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public PermissionResponse createPermission(PermissionRequest request) {

        if (permissionRepository.existsByName(request.getName())) {
            throw new RuntimeException("Permission already exists");
        }

        Permission permission = Permission.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        Permission savedPermission = permissionRepository.save(permission);

        return PermissionResponse.builder()
                .id(savedPermission.getId())
                .name(savedPermission.getName())
                .description(savedPermission.getDescription())
                .build();
    }

    @Override
    public List<PermissionResponse> getAllPermissions() {

        return permissionRepository.findAll()
                .stream()
                .map(permission -> PermissionResponse.builder()
                        .id(permission.getId())
                        .name(permission.getName())
                        .description(permission.getDescription())
                        .build())
                .toList();
    }

    @Override
    public PermissionResponse getPermissionById(Long id) {

        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        return PermissionResponse.builder()
                .id(permission.getId())
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }

    @Override
    public PermissionResponse updatePermission(Long id, PermissionRequest request) {

        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        permission.setName(request.getName());
        permission.setDescription(request.getDescription());

        Permission updatedPermission = permissionRepository.save(permission);

        return PermissionResponse.builder()
                .id(updatedPermission.getId())
                .name(updatedPermission.getName())
                .description(updatedPermission.getDescription())
                .build();
    }

    @Override
    public void deletePermission(Long id) {

        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));

        permissionRepository.delete(permission);
    }
}