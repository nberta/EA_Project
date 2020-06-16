package edu.miu.cs544.service;

import edu.miu.cs544.service.request.UserRequest;
import edu.miu.cs544.service.response.UserResponse;
import edu.miu.cs544.util.Constant.ERole;

public interface RegistrationService {
    UserResponse saveUser(String token, UserRequest userRequest, ERole roleType);
}
