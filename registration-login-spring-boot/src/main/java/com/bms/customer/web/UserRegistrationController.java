package com.bms.customer.web;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.repository.CustomerRepository;
import com.bms.customer.service.UserService;
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
	@Autowired
	private UserService userService;
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
	public ResponseEntity<String>  registerUserAccount(@Valid @RequestBody UserRegistrationDto registrationDto)throws ResourceNotFoundException, SQLException {
		logger.info("$$$$$$$$ CustomerId :"+registrationDto.getCustomerId());
		try{
		Customer custId = customRepository.findByCustomerId(registrationDto.getCustomerId().toString());
			if (custId!=null) {
				
				logger.error(HttpStatus.NOT_FOUND+">>"+"User not found");
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("$$$$$$$$ User already exist");
			}else{
				userService.save(registrationDto);
				}
			
		}
		
		catch(Exception e){
			logger.error("$$$$$$$$ Error in UserRegistration :"+HttpStatus.NOT_ACCEPTABLE+" "+e);
			throw new ResourceNotFoundException("$$$$$$$$ Error in UserRegistration :"+HttpStatus.NOT_ACCEPTABLE+" "+e);
			
		}
		 return ResponseEntity.status(HttpStatus.CREATED).body("$$$$$$$$ User" + registrationDto.getCustomerId()+"Successfully Regisered");
	}
}
