package com.iam.iam_server.controller;

import com.iam.iam_server.entity.Role;
import com.iam.iam_server.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CREATE')")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {

        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_VIEW')")
    public ResponseEntity<List<Role>> getAllRoles() {

        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @PostMapping("/{roleId}/permissions/{permissionId}")
    @PreAuthorize("hasAuthority('ROLE_UPDATE')")
    public ResponseEntity<String> assignPermissionToRole(
            @PathVariable Long roleId,
            @PathVariable Long permissionId) {

        roleService.assignPermissionToRole(roleId, permissionId);

        return ResponseEntity.ok("Permission assigned to role successfully");
    }
}