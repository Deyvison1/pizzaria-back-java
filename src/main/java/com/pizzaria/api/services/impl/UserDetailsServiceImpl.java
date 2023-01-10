package com.pizzaria.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pizzaria.api.exceptions.PasswordInvalidException;
import com.pizzaria.api.models.dtos.UserDTO;
import com.pizzaria.api.services.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private IUserService userService;
    
    private PasswordEncoder encoder;
    
    public UserDetailsServiceImpl(IUserService userService, PasswordEncoder encoder) {
    	this.userService = userService;
    	this.encoder = encoder;
    }
    
    public UserDetails authenticate(com.pizzaria.api.models.User user) {
    	UserDetails userDetails = loadUserByUsername(user.getEmail());
    	boolean passwordsMatches = encoder.matches(user.getPassword(), userDetails.getPassword());
    	
    	if(passwordsMatches) {
    		return userDetails;
    	}
    	throw new PasswordInvalidException();
    }
 
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	UserDTO userDTO = userService.findByEmail(email);

        return User
                .builder()
                .username(userDTO.getEmail())
                .password(userDTO.getPassword())
                .roles(userDTO.getRole())
                .build();
    }

}
