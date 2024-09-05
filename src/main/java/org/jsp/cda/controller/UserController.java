package org.jsp.cda.controller;

import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping(value = "/login")
	public ResponseEntity<?> findByUsernameAndPassword(@RequestBody AuthUser authUser) {
		return service.findByUsernameAndPassword(authUser);
	}

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username)
	{
		return service.getUserByUsername(username);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id)
	{
		return service.deleteUserById(id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllUsers()
	{
		return service.findAllUsers();
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		return service.updateUser(user);
	}
}
