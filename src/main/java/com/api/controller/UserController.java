package com.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.UserRequest;
import com.api.entities.User;
import com.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/singup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> AllUsers() {
		return new ResponseEntity<List<User>>(service.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/byid/{id}")
	public ResponseEntity<User> getUser(@PathVariable ("id") int id) {
		return new ResponseEntity<User>(service.getUser(id), HttpStatus.OK);
	}

}
