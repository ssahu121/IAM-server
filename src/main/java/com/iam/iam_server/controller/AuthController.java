package com.iam.iam_server.controller;

import com.iam.iam_server.dto.RegisterRequest;
import com.iam.iam_server.dto.UserResponse;
import com.iam.iam_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request){

        return ResponseEntity.ok(userService.register(request));

    }
}
