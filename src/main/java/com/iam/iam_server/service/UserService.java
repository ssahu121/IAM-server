package com.iam.iam_server.service;

import com.iam.iam_server.dto.ChangePasswordRequest;
import com.iam.iam_server.dto.RegisterRequest;
import com.iam.iam_server.dto.UpdateProfileRequest;
import com.iam.iam_server.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

    UserResponse updateProfile(String username, UpdateProfileRequest request);

    void changePassword(String username, ChangePasswordRequest request);

    // NEW
    void assignRoleToUser(Long userId, Long roleId);
}