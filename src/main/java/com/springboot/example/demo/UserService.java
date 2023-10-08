package com.springboot.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserData registerUser(UserData user) {
		return userRepository.save(user);
	}

	public void getUsers() {
		// TODO Auto-generated method stub
		userRepository.findAll();
	}

	public UserData getUser(int userId) {
		return userRepository.findById(userId).get();
		
	}

}
