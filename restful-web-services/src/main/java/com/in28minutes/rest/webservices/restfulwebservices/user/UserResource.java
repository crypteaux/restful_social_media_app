package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	//GET /users
	//retrieveAllUsersur
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findall();
	}
	
	
	//Get users/{id}
	@GetMapping("users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return service.findeOne(id);
	}
	//retreiveUser(int id)

}