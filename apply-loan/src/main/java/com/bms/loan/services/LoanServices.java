package com.bms.loan.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.bms.loan.exception.CustomerException;
import com.bms.loan.model.Customer;
import com.bms.loan.model.Loan;


public interface LoanServices{
	public List<Customer> getCustomerList(String customerId) throws CustomerException;
	public Loan applyLoan(Loan loanObj,String custId) throws CustomerException;
}
