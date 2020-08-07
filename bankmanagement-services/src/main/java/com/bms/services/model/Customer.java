package com.bms.services.model;

public class Customer {
	
	private long id;
	private int customerId;
	private String customerName;
	private String password;
	private String address;
	private String email;
	private String state;
	private String country;
	Account account;
	
	public Customer() {}
	public Customer(long id, int customerId, String customerName, String password, String address, String email, String state,
			String country) {
		super();
		this.id=id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.state = state;
		this.country = country;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
