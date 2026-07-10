package com.iam.iam_server.controller;

import com.iam.iam_server.dto.ForgotPasswordRequest;
import com.iam.iam_server.dto.ResetPasswordRequest;
import com.iam.iam_server.dto.LoginRequest;
import com.iam.iam_server.dto.LoginResponse;
import com.iam.iam_server.dto.RegisterRequest;
import com.iam.iam_server.dto.UserResponse;
import com.iam.iam_server.service.AuthService;
import com.iam.iam_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(
            @RequestBody ForgotPasswordRequest request) {

        authService.forgotPassword(request);

        return ResponseEntity.ok("Password reset token generated");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(
            @RequestBody ResetPasswordRequest request) {

        authService.resetPassword(request);

        return ResponseEntity.ok("Password reset successfully");
    }
}