package com.bms.loan.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.loan.controller.LoanController;
import com.bms.loan.exception.CustomerException;
import com.bms.loan.model.Customer;
import com.bms.loan.model.Loan;
import com.bms.loan.repository.CustomerRepository;


@Service
public class LoanServiceImpl implements LoanServices{
	
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private com.bms.loan.repository.LoanRepository loanRepository;
	@Override
	public List<Customer> getCustomerList(String customerId) throws CustomerException {
		List<Customer> custId = customerRepository.findByCustomerId(customerId);
		return custId;
	}
	@Override
	public Loan applyLoan(Loan loanObj, String custId) throws CustomerException {
		 List<Customer>   cust = customerRepository.findByCustomerId(custId);

		 if(cust.isEmpty()) {
			 logger.error("$$$$$$$ Customer ID not found :: " + loanObj.getCustomerId());
				 throw new CustomerException("Customer ID not found :: " + loanObj.getCustomerId());
				 
			 }else {
				 Loan loan=new Loan();
				 loan.setAccountNumber(cust.get(0).getAccount().getAccountNumber());
				 loan.setAccountType(cust.get(0).getAccount().getAccountType());
				 loan.setCustomerId(cust.get(0).getCustomerId());
				 loan.setLoanType(loanObj.getLoanType());
				 loan.setLoanAmount(loanObj.getLoanAmount());
				 loan.setLoanId(loanObj.getLoanId());
				 loan.setLoanDate(loanObj.getLoanDate());
				 loan.setRateOfInterest(loanObj.getRateOfInterest());
				 loanRepository.save(loan);
				 logger.info("$$$$$$$ Loan Deails Saved Success Fully for : " + loanObj.getCustomerId());      
			 }
			return loanObj;
			 }
	}

