package com.bms.services.model;

public class Loan {
	private int loanId;
	private String loanType;
	private double loanAmount;
	private String loanDate;
	private double rateOfInterest;
	private String durationOfLoan;
	
	public Loan() {}

	public Loan(int loanId, String loanType, double loanAmount, String loanDate, double rateOfInterest,
			String durationOfLoan) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanDate = loanDate;
		this.rateOfInterest = rateOfInterest;
		this.durationOfLoan = durationOfLoan;
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
	
}
