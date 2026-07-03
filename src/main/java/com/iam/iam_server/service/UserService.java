package com.iam.iam_server.service;

import com.iam.iam_server.dto.RegisterRequest;
import com.iam.iam_server.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterRequest request);

}