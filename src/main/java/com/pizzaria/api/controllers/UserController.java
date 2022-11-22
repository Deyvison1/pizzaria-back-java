package com.pizzaria.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizzaria.api.models.User;
import com.pizzaria.api.models.dtos.UserDTO;
import com.pizzaria.api.services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> add(@RequestBody User user) {
		 return ResponseEntity.ok(userService.add(user));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(userService.findAll()); 
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	
	
}
