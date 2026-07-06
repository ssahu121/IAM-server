package com.iam.iam_server.service;

import com.iam.iam_server.dto.LoginRequest;
import com.iam.iam_server.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}