package com.naveen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.entity.User;
import com.naveen.service.UserServiceInterface;


@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserServiceInterface serviceInterface;

	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		User createdUser = serviceInterface.createUser(user);
		return new ResponseEntity<User>(createdUser, HttpStatusCode.valueOf(200));
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		User user = serviceInterface.getUser(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/status")
	public String statusCheck() {
		return "Working...";
	}
}
