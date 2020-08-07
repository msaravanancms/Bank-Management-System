package com.bms.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.loan.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//@Async
	//@Query("SELECT * FROM Customer c WHERE c.customerId=:customerId")
	 // List<Customer>  findByCustomerId(@Param("customerId") Integer customerId );
	//public Customer createCustomer(Customer customerObj);
	public List<Customer> findByCustomerId(String customerId);
}
