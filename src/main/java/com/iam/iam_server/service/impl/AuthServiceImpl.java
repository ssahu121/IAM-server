package com.iam.iam_server.service.impl;

import com.iam.iam_server.dto.LoginRequest;
import com.iam.iam_server.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(LoginRequest request) {

        return "Login Success";

    }
}