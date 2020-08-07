package com.bms.loan.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.loan.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	//public Customer createCustomer(Customer customerObj);
	//public List<Customer> getCustomerList(Integer customerId);

}
