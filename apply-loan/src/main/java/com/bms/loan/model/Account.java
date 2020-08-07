package com.bms.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
	
	@Column(name = "customerId")
	private String customerId;
	
	@Column(name = "accountName")
	private String accountName;
	
	@Column(name = "accountNumber")
	private int accountNumber;
	
	@Column(name = "panNumber")
	private String panNumber;
	
	@Column(name = "accountType")
	private String accountType;
	
	@Column(name = "dob")
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
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
