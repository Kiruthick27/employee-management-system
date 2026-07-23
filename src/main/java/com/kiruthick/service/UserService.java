package com.kiruthick.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiruthick.model.User;
import com.kiruthick.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public String register(User user){
		User existinguser=userRepository.findByUsername(user.getUsername());
		
		if(existinguser!=null) {
			return "Username Allready exists";
		}
		
		userRepository.save(user);
		return "Registration Successful";
	}
	
	public boolean login(User user) {
		User existinguser=userRepository.findByUsername(user.getUsername());
		if(existinguser==null) {
			return false;
		}
		return existinguser.getPassword().equals(user.getPassword());
	}
}
