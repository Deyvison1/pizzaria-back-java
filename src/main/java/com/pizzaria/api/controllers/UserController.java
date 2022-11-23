package com.pizzaria.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pizzaria.api.config.jwt.impl.JwtServiceImpl;
import com.pizzaria.api.controllers.dtos.CredentialsDTO;
import com.pizzaria.api.controllers.dtos.TokenDTO;
import com.pizzaria.api.exceptions.PasswordInvalidException;
import com.pizzaria.api.models.User;
import com.pizzaria.api.models.dtos.UserDTO;
import com.pizzaria.api.services.IUserService;
import com.pizzaria.api.services.impl.UserDetailsServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private IUserService userService;
	private UserDetailsServiceImpl userDetailsService;
	private JwtServiceImpl jwtService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserDTO> add(@RequestBody User user) {
		 return ResponseEntity.ok(userService.add(user));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(userService.findAll()); 
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	
	@PostMapping("/auth")
	public TokenDTO Authenticate(@RequestBody CredentialsDTO credentialsDTO) {
		try {
			User usuario = User.builder().email(credentialsDTO.getEmail()).password(credentialsDTO.getPassword()).build();
			UserDetails userDetails = userDetailsService.authenticate(usuario);
			String token = jwtService.generateToken(usuario);
			return new TokenDTO(usuario.getEmail(), token);
		} catch (UsernameNotFoundException | PasswordInvalidException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	
}
