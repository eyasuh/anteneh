package com.example.springboot4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public User getUser(){

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String currentusername = authentication.getName();

		User user = userRepository.findByUsername(currentusername);

		return user;
	}
}