package com.bms.loan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.loan.exception.CustomerException;
import com.bms.loan.exception.ResourceNotFoundException;
import com.bms.loan.model.Customer;
import com.bms.loan.model.Loan;
import com.bms.loan.repository.LoanRepository;
import com.bms.loan.services.LoanServices;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/loanservice")
@Api(tags = { "loanservice and REST endpoints" })
public class LoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	private LoanServices loanServices;
	
	@PostMapping("/applyloan")
	  public ResponseEntity<Loan> applyLoan(@Valid @RequestBody  Loan loanObj)throws ResourceNotFoundException, CustomerException{
		try {
			Loan loan = loanServices.applyLoan(loanObj, loanObj.getCustomerId());
		
		}catch(Exception e) {
			 logger.error("$$$$$$$ The givenLoan ID is already Exist : " + loanObj.getCustomerId());  
			 throw new ResourceNotFoundException("The givenLoan ID is already Exist d :: " + loanObj.getCustomerId());
		}
		return ResponseEntity.ok(loanObj);
		 }

}
