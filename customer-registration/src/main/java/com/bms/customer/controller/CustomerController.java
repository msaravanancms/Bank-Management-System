package com.bms.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.customer.exception.CustomerException;
import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.service.CustomerServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customerService")
@Api(tags = { "Banking Managemens and REST endpoints" })
public class CustomerController {
	@Autowired
	private CustomerServices customerServices;
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@ApiOperation(value = "Add a Customer", notes = "Add customer and create an account")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })

	@PutMapping("/customerObj/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable(value = "id") String customerId,
			@RequestBody Customer customerObj) throws ResourceNotFoundException, CustomerException {

		try {
			List<Customer> custOb = customerServices.getCustomerList(customerObj.getCustomerId());
			if (custOb.isEmpty()) {
				logger.error(HttpStatus.NOT_FOUND+">>"+"$$$$$$ Customer ID not found");
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer ID : " + customerObj.getCustomerId() +" not found");
			} else {

				customerServices.updateCustomer(customerObj, custOb.get(0).getId());
				logger.info(" $$$$$$ Customer udated Successflly :: " );
			}

		} catch (Exception e) {
			logger.error(" $$$$$$ Exception :: "+e );
			throw new ResourceNotFoundException("Exception in Customer update :: " + e +""+HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body("$$$$$$$$ Customer udated Successflly");
		
	}
	}
	
