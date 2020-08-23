package com.bms.loan.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.loan.exception.CustomerException;
import com.bms.loan.exception.ResourceNotFoundException;
import com.bms.loan.model.Loan;
import com.bms.loan.services.LoanServices;

import io.swagger.annotations.Api;

@RestController
@Api(tags = { "loanservice and REST endpoints" })
public class LoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	private LoanServices loanServices;
	
	@PostMapping("/applyloan")
	  public ResponseEntity<String> applyLoan(@Valid @RequestBody  Loan loanObj)throws CustomerException{
		logger.info("$$$$$$$$ Loan Method");
		try {
			Loan loan = loanServices.applyLoan(loanObj, loanObj.getCustomerId());
		
		}catch(Exception e) {
			logger.error(""+HttpStatus.NOT_FOUND);
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("$$$$$$$$"+ e);
		}
		logger.info("$$$$$$$$ Loan Creaed Successfully"+loanObj.getLoanId());
		return ResponseEntity.status(HttpStatus.CREATED).body("$$$$$$$$ Loan Creaed Successfully");
		 }

}
