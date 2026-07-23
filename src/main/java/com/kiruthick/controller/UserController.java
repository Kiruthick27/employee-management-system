package com.kiruthick.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiruthick.model.User;
import com.kiruthick.service.UserService;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user){
		
		String message=userService.register(user);
		
		if(message.equals("Username Allready exists")) {
			return ResponseEntity.badRequest().body(message);
		}
		
		return ResponseEntity.ok(message);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<String> login(@RequestBody User user){
		
		boolean isValid =userService.login(user);
		
		if(isValid) {
			return ResponseEntity.ok("Login Successful");
		}
		
		return ResponseEntity.status(401).body("Incorrect Username or Password");
	}
	
}
