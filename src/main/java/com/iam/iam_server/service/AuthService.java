package com.iam.iam_server.service;

import com.iam.iam_server.dto.ForgotPasswordRequest;
import com.iam.iam_server.dto.LoginRequest;
import com.iam.iam_server.dto.LoginResponse;
import com.iam.iam_server.dto.ResetPasswordRequest;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    void forgotPassword(ForgotPasswordRequest request);

    void resetPassword(ResetPasswordRequest request);
}