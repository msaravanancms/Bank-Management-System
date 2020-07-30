package com.bms.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//public Customer createCustomer(Customer customerObj);
	//public List<Customer> getCustomerList(Integer customerId);
}
