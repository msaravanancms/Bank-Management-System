package com.bms.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;

public interface AccountRepository extends JpaRepository<Account, Long>{
	//public Customer createCustomer(Customer customerObj);
	//public List<Customer> getCustomerList(Integer customerId);

}
