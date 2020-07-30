package com.bms.customer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;
import com.bms.customer.service.AccountRepository;
import com.bms.customer.service.CustomerRepository;
import javax.validation.Valid;
@RestController
@RequestMapping("/customerService")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	  @PostMapping("/customerObj") 
	  public Customer createCustomer(@Valid @RequestBody  Customer customerObj){
	  
		  Customer customer = new Customer();
			 customer.setCustomerName(customerObj.getCustomerName());
			 customer.setAddress(customerObj.getAddress());
			 customer.setPassword(customerObj.getPassword());
			 customer.setCustomerId(customerObj.getCustomerId());
			 customer.setEmail(customerObj.getEmail());
			
			 
			 Account acc = new Account();
			 acc.setAccountName(customerObj.getAccount().getAccountName());
			 acc.setAccountNumber(customerObj.getAccount().getAccountNumber());
			 acc.setAccountType(customerObj.getAccount().getAccountType());
			 acc.setDob(customerObj.getAccount().getDob());
			 acc.setPanNumber(customerObj.getAccount().getPanNumber());
			 acc.setCustomerId(customerObj.getCustomerId());
			 customer.setAccount(acc);
			//accountRepository.save(acc);
			 
			 customerRepository.save(customer);
			 
		  return customer; }
	 
	  @PutMapping("/customerObj/{id}")
	  public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long CustomerId, @RequestBody  Customer customerObj){
	 System.out.println( "CCCCCC:"+CustomerId);
		  Optional<Customer>  cust = customerRepository.findById(CustomerId);
		  System.out.println( "CCCCCC  cust:"+cust);
		  Customer updatedUser=null;
		 if(cust.isEmpty()) {
			 
		 }else {
			
			 Customer customer = new Customer();
			 customer.setCustomerId(CustomerId);
			  customer.setCustomerName(customerObj.getCustomerName());
				 customer.setAddress(customerObj.getAddress());
				 customer.setPassword(customerObj.getPassword());
				 customer.setCustomerId(customerObj.getCustomerId());
				 customer.setEmail(customerObj.getEmail());
				
				 
				 Account acc = new Account();
				 acc.setId(cust.get().getAccount().getId());
				 acc.setAccountName(customerObj.getAccount().getAccountName());
				 acc.setAccountNumber(customerObj.getAccount().getAccountNumber());
				 acc.setAccountType(customerObj.getAccount().getAccountType());
				 acc.setDob(customerObj.getAccount().getDob());
				 acc.setPanNumber(customerObj.getAccount().getPanNumber());
				 acc.setCustomerId(customerObj.getCustomerId());
				 customer.setAccount(acc);
			     updatedUser = customerRepository.save(customer);
			        
		 }
		 
	      return ResponseEntity.ok(updatedUser);
		        
		 }
	
	  @GetMapping("/{customerId}")
	public List<Customer> getCustomerList(@PathVariable("customerId")String customerId){
		
		 List<Customer> list = new ArrayList();
		 Customer custom = new Customer();
		 custom.setAddress("chennaione");
		 custom.setPassword("sarankmar");
		 custom.setCustomerId(2224);
		 custom.setEmail("msaravanancms@gmail.com");
		 list.add(custom);
		return list;
	}
}
