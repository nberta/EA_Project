package edu.miu.cs544.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.exception.JwtTokenException;
import edu.miu.cs544.service.AuthenticationService;
import edu.miu.cs544.service.response.UserResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping(value = "/validate")
	public UserResponse validateToken(@RequestBody String token) {	
		return authenticationService.validateTokenGet(token);
	}
	
	@GetMapping(value = "/validate")
	public UserResponse validateToken(HttpServletRequest request) {	
		String header = request.getHeader("Authorization");
		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenException("No JWT token found in request headers.");
		}
		String token = header.substring(7);
		return authenticationService.validateTokenGet(token);
	}
}
