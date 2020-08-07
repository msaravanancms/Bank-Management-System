package com.bms.customer.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bms.customer.model.User;
import com.bms.customer.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}