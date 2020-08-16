package com.bms.customer.service;


import javax.validation.Valid;


import com.bms.customer.model.User;
import com.bms.customer.web.dto.UserRegistrationDto;

public interface UserService{
	User save(UserRegistrationDto registrationDto);
	 public User login(String userId);
}