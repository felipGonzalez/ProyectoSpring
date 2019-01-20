package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.models.User;
import com.example.demo.util.RestResponse;

@RestController
@RequestMapping("/list")
public class UserController {

	@Autowired
	private UserService userService;
	
	//obtener usuario
	@GetMapping(value="")
	public List<User> getList() {
		return userService.getAll();
	}
	
	
	//agregar usuario
	@PostMapping(value="")
	public RestResponse createUser(@RequestBody User user) {
		if(!this.validateUser(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios mo estan dligenciados ");
		}
		userService.save(user);
		
		return new RestResponse(HttpStatus.OK.value(), "Operecion exitosa");
	}
	

	
	private boolean validateUser(User user) {
		boolean isvalid = true;
		if(user.getFirstName() == "" || user.getFirstName() == null) {
			isvalid = false;
		}
		
		if( user.getFirstName() == "" || user.getFirstSurname() == null) {
			isvalid = false;
		}
		
		if( user.getFirstName() == "" || user.getFirstSurname() == null) {
			isvalid = false;
		}
		return isvalid;
	}
	
	@DeleteMapping(value = "{id}")
    public RestResponse removePerson(@PathVariable int id){
		try {
			userService.removePerson(new Long(id));
			return new RestResponse(HttpStatus.OK.value(), "usuario borrado");
		} catch (Exception e) {
			
			return new RestResponse(HttpStatus.EXPECTATION_FAILED.value(), "usuario no encontrado");
		}
    }
 
		
}
