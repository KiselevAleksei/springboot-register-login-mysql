package com.kiselev.springbootreglogindemo.service;

import com.kiselev.springbootreglogindemo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.kiselev.springbootreglogindemo.web.dto.UserRegistrationDto;

import java.util.List;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);

	User findByEmail(String email);

	List<UserRegistrationDto> findAllUsers();
}
