package edu.miu.cs544.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.exception.JwtTokenException;
import edu.miu.cs544.service.RegistrationService;
import edu.miu.cs544.service.request.UserRequest;
import edu.miu.cs544.service.response.UserResponse;
import edu.miu.cs544.util.Constant.ERole;

@RestController
@RequestMapping("/sign-up")
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/passenger")
    public UserResponse registerPassenger(@RequestHeader("Authorization") String header, @Valid @RequestBody UserRequest userRequest) {
		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenException("No JWT token found in request headers.");
		}
		String token = header.substring(7);
        return registrationService.saveUser(token, userRequest, ERole.ROLE_PASSENGER);
    }
	
	@PostMapping("/agent")
    public UserResponse registerAgent(@RequestHeader("Authorization") String header, @Valid @RequestBody UserRequest userRequest) {
		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenException("No JWT token found in request headers.");
		}
		String token = header.substring(7);
        return registrationService.saveUser(token, userRequest, ERole.ROLE_AGENT);
    }
	
	@PostMapping("/admin")
    public UserResponse registerAdmin(@RequestHeader("Authorization") String header, @Valid @RequestBody UserRequest userRequest) {
		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenException("No JWT token found in request headers.");
		}
		String token = header.substring(7);
        return registrationService.saveUser(token, userRequest, ERole.ROLE_ADMIN);
    }
}
