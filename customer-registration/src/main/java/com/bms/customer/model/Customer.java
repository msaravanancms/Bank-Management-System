package com.bms.customer.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "customerId")
	private String customerId;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "password")
	private String password;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	Account account;
	
	public Customer() {}
	public Customer(long id, String customerId, String customerName, String password, String address, String email, String state,
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
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
