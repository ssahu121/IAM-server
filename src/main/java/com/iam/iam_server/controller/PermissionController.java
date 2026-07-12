package com.iam.iam_server.controller;

import com.iam.iam_server.dto.PermissionRequest;
import com.iam.iam_server.dto.PermissionResponse;
import com.iam.iam_server.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<PermissionResponse> createPermission(
            @RequestBody PermissionRequest request) {

        return ResponseEntity.ok(permissionService.createPermission(request));
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponse>> getAllPermissions() {

        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponse> getPermissionById(
            @PathVariable Long id) {

        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponse> updatePermission(
            @PathVariable Long id,
            @RequestBody PermissionRequest request) {

        return ResponseEntity.ok(permissionService.updatePermission(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePermission(
            @PathVariable Long id) {

        permissionService.deletePermission(id);

        return ResponseEntity.ok("Permission deleted successfully");
    }
}