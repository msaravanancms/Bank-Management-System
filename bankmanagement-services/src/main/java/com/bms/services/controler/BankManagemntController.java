package com.bms.services.controler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bms.services.model.Customer;
import com.bms.services.model.CustomerList;

@RestController
@RequestMapping("/bankmanagement")
public class BankManagemntController {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/{customerId}")
	public List<Customer> getCustomerList(@PathVariable("customerId")String customerId){
		
		// List<Customer> list = restTemplate.getForObject("http://localhost:8081/customerService/foo", CustomerList.class);
		
		 List<Customer> list = new ArrayList();
		 Customer customer = new Customer();
		 customer.setAddress("chennai");
		 customer.setPassword("saran");
		 customer.setCustomerId(222);
		 customer.setEmail("msaravanancms@gmail.com");
		 list.add(customer);
		return list;
	}

}
