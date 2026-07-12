package com.iam.iam_server.controller;

import com.iam.iam_server.dto.ChangePasswordRequest;
import com.iam.iam_server.dto.UpdateProfileRequest;
import com.iam.iam_server.dto.UserResponse;
import com.iam.iam_server.entity.User;
import com.iam.iam_server.repository.UserRepository;
import com.iam.iam_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(Authentication authentication) {

        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(
            Authentication authentication,
            @RequestBody UpdateProfileRequest request) {

        return ResponseEntity.ok(
                userService.updateProfile(authentication.getName(), request)
        );
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            Authentication authentication,
            @RequestBody ChangePasswordRequest request) {

        userService.changePassword(authentication.getName(), request);

        return ResponseEntity.ok("Password changed successfully");
    }

    @PostMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<String> assignRoleToUser(
            @PathVariable Long userId,
            @PathVariable Long roleId) {

        userService.assignRoleToUser(userId, roleId);

        return ResponseEntity.ok("Role assigned to user successfully");
    }
}