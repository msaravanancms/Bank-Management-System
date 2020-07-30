package com.bms.loan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.loan.model.Customer;
import com.bms.loan.model.Loan;
import com.bms.loan.services.CustomerRepository;
import com.bms.loan.services.LoanRepository;

@RestController
@RequestMapping("/loanservice")
public class LoanController {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LoanRepository loanRepository;
	
	@PutMapping("/loanService/{id}")
	  public ResponseEntity<Loan> applyLoan(@PathVariable(value = "id") Long CustomerId, @RequestBody  Loan loanObj){
	  
		  Optional<Customer>  cust = customerRepository.findById(CustomerId);
		  Loan updatedLoan=null;
		 if(cust.isEmpty()) {
			 
		 }else {
			 Loan loan = new Loan();
			 loan.setAccountNumber(cust.get().getAccount().getAccountNumber());
			 loan.setAccountType(cust.get().getAccount().getAccountType());
			 loan.setCustomerId(cust.get().getCustomerId());
			 loan.setLoanType(loanObj.getLoanType());
			 loan.setLoanAmount(loanObj.getLoanAmount());
			 //loan.setLoanId(loanId);
			 loan.setLoanDate(loanObj.getLoanDate());
			 loan.setRateOfInterest(loanObj.getRateOfInterest());
			     updatedLoan= loanRepository.save(loan);
			        
		 }
		return ResponseEntity.ok(updatedLoan);
		 }
		 
	
	@RequestMapping("/{loanId}")
	public List<Loan> getCustomerList(@PathVariable("loanId")String customerId){
		 List<Loan> list = new ArrayList();
		 Loan customer = new Loan();
		 list.add(customer);
		return list;
	}

}
