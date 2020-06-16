package edu.miu.cs544.service;

import edu.miu.cs544.exception.EmailAlreadyExistException;
import edu.miu.cs544.service.request.UserRequest;
import edu.miu.cs544.service.response.UserResponse;
import edu.miu.cs544.util.Constant.ERole;

public interface RegistrationService {
    UserResponse saveUser(UserRequest userRequest, ERole roleType) throws EmailAlreadyExistException;
}
