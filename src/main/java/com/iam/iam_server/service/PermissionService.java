package com.iam.iam_server.service;

import com.iam.iam_server.dto.PermissionRequest;
import com.iam.iam_server.dto.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse createPermission(PermissionRequest request);

    List<PermissionResponse> getAllPermissions();

    PermissionResponse getPermissionById(Long id);

    PermissionResponse updatePermission(Long id, PermissionRequest request);

    void deletePermission(Long id);
}