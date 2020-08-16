package com.bms.customer.web.dto;

import javax.persistence.Column;

public class LoginDto {
	private String customerId;
	private String password;
	
	public LoginDto(){
		
	}

	public LoginDto(String customerId, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
