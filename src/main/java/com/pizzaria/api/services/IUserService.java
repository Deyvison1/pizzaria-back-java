package com.pizzaria.api.services;

import java.util.List;

import com.pizzaria.api.models.User;
import com.pizzaria.api.models.dtos.UserDTO;

public interface IUserService {
	UserDTO add(User user);
	
	List<UserDTO> findAll();
	
	UserDTO findById(Long id);
	
	UserDTO findByEmail(String email);
}
