package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.models.User;

@Service
public class UserService {

	
	@Autowired
	 private UserRepository userRepository;
	 
	 public List<User> getAll() {
		 return userRepository.findAll();
	 }
	 
	 public void save(User user) {
		 userRepository.save(user);
	 }
}
