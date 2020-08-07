package com.bms.services.model;


public class Account {
	private long id;
	
	private long customerId;
	private String accountName;
	private int accountNumber;
	private String panNumber;
	private String accountType;
	private String dob;
	
	public Account() {}

	public Account(long id, String accountName, int accountNumber, String panNumber, String accountType, String dob,Customer customer) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.panNumber = panNumber;
		this.accountType = accountType;
		this.dob = dob;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
}
