package com.bms.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.loan.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	//public Customer createCustomer(Customer customerObj);
	public List<Loan> findByLoanId(int loanId);
}