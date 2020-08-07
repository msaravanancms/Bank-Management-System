package com.bms.services.model;


public class Loan {
	
	private long id;
	private int loanId;
	private String loanType;
	private double loanAmount;
	private String loanDate;
	private double rateOfInterest;
	private String durationOfLoan;
	private int accountNumber;
	private int customerId;
	private String accountType;
	
	public Loan() {}


	public Loan(long id, int loanId, String loanType, double loanAmount, String loanDate, double rateOfInterest,
			String durationOfLoan, int accountNumber, int customerId, String accountType) {
		super();
		this.id = id;
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanDate = loanDate;
		this.rateOfInterest = rateOfInterest;
		this.durationOfLoan = durationOfLoan;
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.accountType = accountType;
	}


	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getDurationOfLoan() {
		return durationOfLoan;
	}

	public void setDurationOfLoan(String durationOfLoan) {
		this.durationOfLoan = durationOfLoan;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
}
