package com.iam.iam_server.service;

import com.iam.iam_server.entity.Role;

import java.util.List;

public interface RoleService {

    Role createRole(Role role);

    List<Role> getAllRoles();
}