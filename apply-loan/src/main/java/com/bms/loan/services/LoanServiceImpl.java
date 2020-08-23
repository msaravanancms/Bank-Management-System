package com.bms.loan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.loan.exception.CustomerException;
import com.bms.loan.model.Customer;
import com.bms.loan.model.Loan;
import com.bms.loan.repository.CustomerRepository;
import com.bms.loan.repository.LoanRepository;


@Service
public class LoanServiceImpl implements LoanServices{
	
	private static final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);
	 boolean flag=true;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LoanRepository loanRepository;
	@Override
	public List<Customer> getCustomerList(String customerId) throws CustomerException {
		List<Customer> Custlist = customerRepository.findByCustomerId(customerId);

		
		Custlist.forEach(item->{
			if(customerId.equals(item.getCustomerId())){
				logger.info("customerId  is available");
			}
		});
		
		if (Custlist.stream().count() > 0) {
			
			logger.info("Customer  Lis");
			 throw new CustomerException("The given Loan ID is does not Exist");
		}
		
		return Custlist;
	}
	@Override
	public Loan applyLoan(Loan loanObj, String custId) throws CustomerException {
		 List<Customer>   cust = customerRepository.findByCustomerId(custId);

		 if (cust.stream().count() == 0) {
			 logger.error("$$$$$$$ Customer ID not found :: ");
				 throw new CustomerException("Customer ID not found :: " + loanObj.getCustomerId());
			}
		 
		 List<Loan>   loanList = loanRepository.findByLoanId(loanObj.getLoanId());
		 
		 if (loanList.stream().count() == 0) {
				
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
				 logger.info("$$$$$$$ Loan Deails Saved Success Fully for : " ); 
			}else {
				throw new CustomerException("Loan ID already Exis :: " + loanObj.getLoanId());
			}
			return loanObj;
			 }
}
