package com.bms.customer.web;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.repository.CustomerRepository;
import com.bms.customer.service.UserService;
import com.bms.customer.service.UserServiceImpl;
import com.bms.customer.web.dto.UserRegistrationDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@RequestMapping("/registercustomer")
@Api(tags = { "UserRegistrationController and REST endpoints" })
public class UserRegistrationController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);
	
	private UserService userService;
	private UserServiceImpl  userServiceIm;
	@Autowired
	private CustomerRepository  customRepository;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ApiOperation(value = "Add a Customer", notes = "Add customer and create an account")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@PostMapping("/customeregistration")
	public ResponseEntity<UserRegistrationDto>  registerUserAccount(@Valid @RequestBody UserRegistrationDto registrationDto)throws ResourceNotFoundException, SQLException {
		logger.info("$$$$$$$$ CustomerId :"+registrationDto.getCustomerId());
		try{
			List<Customer> custId = customRepository.findByCustomerId(registrationDto.getCustomerId().toString());
			if (custId.isEmpty()) {
				userService.save(registrationDto);
				logger.info("$$$$$$$$ UserRegistration Saved sccessflly");
			}else{
				
				throw new ResourceNotFoundException("Customer ID already Exis :: " +registrationDto.getCustomerId());
				}
			
		}
		
		catch(Exception e){
			logger.error("$$$$$$$$ Error in UserRegistration :"+HttpStatus.CONFLICT);
			return (ResponseEntity) ResponseEntity.status( HttpStatus.CONFLICT);
			
		}
		return ResponseEntity.ok(registrationDto);
	}
}
