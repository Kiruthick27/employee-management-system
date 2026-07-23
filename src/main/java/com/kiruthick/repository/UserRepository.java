package com.kiruthick.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiruthick.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUsername(String username);
}