package com.iam.iam_server.service;

import com.iam.iam_server.dto.LoginRequest;

public interface AuthService {

    String login(LoginRequest request);

}