package com.bms.services.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bms.services.model.Customer;
import com.bms.services.model.CustomerList;
import com.bms.services.model.Loan;

@RestController
@RequestMapping("/bankmanagement")
public class BankManagemntController {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@PostMapping("/customerObj") 
	  public Customer createCustomer(@Valid @RequestBody  Customer customerObj) throws Exception{
		Customer cs =new Customer();
		try{
		 cs = restTemplate.postForObject("http://localhost:8081/customerService/customerObj", customerObj, Customer.class);
		// List<Customer> list = restTemplate.getForObject("http://localhost:8081/customerService/foo", CustomerList.class);
		}catch(Exception e) {
			System.out.println("NMMMMMMMMSSSSSSSS:"+e);
		}
		return cs;
	}
	
	 @PutMapping("/customerObj/{id}")
	  public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer customerId, @RequestBody  Customer customerObj) throws Exception{
		  Customer updatedUser=null;
		Customer cs =null;
		try{
			Map<String, String> params = new HashMap<String, String>();
		    params.put("id", "2");
		 restTemplate.put("http://localhost:8081/customerService/customerObj/{id}", customerObj, params);
		
		}catch(Exception e) {
			 
		}
		 
	      return ResponseEntity.ok(updatedUser);
	}
	
	 @PostMapping("/applyloan")
	  public ResponseEntity<Loan> applyLoan(@Valid @RequestBody  Loan loanObj)throws Exception{
		 
		 
			 Loan loan =null;
		try{
			loan = restTemplate.postForObject("http://localhost:8082/loanservice/applyloan", loanObj, Loan.class);
		
		}catch(Exception e) {
			 
		}
		 
	      return ResponseEntity.ok(loan);
	}

}
