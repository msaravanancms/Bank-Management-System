package com.bms.customer.model;

public class CustomerResponse {
	private int status;
    private String message;
    private Object result;

    public CustomerResponse(int status, String message, Object result){
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }
    
}
