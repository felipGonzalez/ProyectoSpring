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
	 
	
	/**
	 * Recupera la lista de usuarios 
	 * @return lista de usuarios 
	 * **/
	 public List<User> getAll() {
		 return userRepository.findAll();
	 }
	 /**
	  * Guarda un usuario
	  * @param user
	  * @return el usuario guardado
	  * **/
	 public void save(User user) {
		 userRepository.save(user);
	 }
	 
	 public void removePerson(Long id) {
		 userRepository.deleteById(id);
	 }
}
