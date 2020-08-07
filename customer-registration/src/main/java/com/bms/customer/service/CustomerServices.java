package com.bms.customer.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.bms.customer.exception.CustomerException;
import com.bms.customer.model.Customer;

public interface CustomerServices{
	public List<Customer> getCustomerList(String customerId) throws CustomerException;
	public Customer updateCustomer(Customer customerObj,long custId) throws CustomerException;
}
