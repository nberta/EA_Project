package edu.miu.cs544.security.service;

import edu.miu.cs544.service.response.UserResponse;

public interface AuthValidationService {
    UserResponse validateToken(String token);
}
