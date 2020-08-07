package com.bms.customer.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.customer.exception.CustomerException;
import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;
import com.bms.customer.repository.AccountRepository;
import com.bms.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerServices{
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public List<Customer> getCustomerList(String customerId) throws CustomerException {
		List<Customer> custId = customerRepository.findByCustomerId(customerId);
		return custId;
	}

	@Override
	public Customer updateCustomer(@Valid Customer customerObj, long custId) throws CustomerException {
		
		
		Optional<Customer> cust = customerRepository.findById(custId);
		System.out.println("ccccccccccccccccccc:" + custId);
		if (cust.isEmpty()) {
			throw new CustomerException("Customer ID already Exis :: " + customerObj.getCustomerId());
		} else {
			Customer customer = new Customer();
			customer.setId(custId);
			customer.setCustomerId(customerObj.getCustomerId());
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
			customerRepository.save(customer);

		}
		return customerObj;
	}
	
}
