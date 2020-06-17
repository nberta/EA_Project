package edu.miu.cs544.service;

import edu.miu.cs544.domain.User;

public interface UserService {
	User getByUsername(String username);
}
