package com.pizzaria.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pizzaria.api.exceptions.NotFoundException;
import com.pizzaria.api.models.User;
import com.pizzaria.api.models.dtos.UserDTO;
import com.pizzaria.api.models.repository.IUserRepository;
import com.pizzaria.api.services.IUserService;
import com.pizzaria.api.utils.mappers.IUserMapper;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository userRepo;
	private IUserMapper userMapper;
	private PasswordEncoder encoder;

	public UserServiceImpl(IUserRepository userRepo, IUserMapper userMapper, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.userMapper = userMapper;
		this.encoder = encoder;
	}

	@Override
	public UserDTO add(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userMapper.toDTO(userRepo.save(user));
	}

	@Override
	public List<UserDTO> findAll() {
		return userMapper.toDTOList(userRepo.findAll());
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return userMapper.toDTO(user.orElseThrow(() -> new NotFoundException()));
	}

	@Override
	public UserDTO findByEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return userMapper.toDTO(user.orElseThrow(() -> new NotFoundException()));
	}
}
