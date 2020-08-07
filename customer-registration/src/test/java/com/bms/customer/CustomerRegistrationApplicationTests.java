package com.bms.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CustomerRegistrationApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("test Message REST API ")
	void testMessage() {
		
		Customer userRegr = new Customer();	
		Account acc = new Account();
		userRegr.setCustomerId("88889");
		acc.setAccountNumber(4542222);
		acc.setAccountType("string");
		acc.setAccountName("Saving");
		acc.setDob("54566");
		acc.setPanNumber("4545454");
		userRegr.setAddress("chennai");
		userRegr.setPassword("saravanan");
		userRegr.setEmail("msaravanancms@gmail.com");
		userRegr.setState("chennai");
		userRegr.setCountry("chennai");
		userRegr.setCustomerName("saravanan");
		userRegr.setAccount(acc);
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "555889");
	    restTemplate.put("/customerService/customerObj/{id}", userRegr, params);
	//	Customer  message = this.restTemplate.postForObject("/customerService/customerObj/{id}",userRegr, Customer.class);
			//System.out.println("@@@@:"+message.getCustomerId());
		assertEquals(userRegr, userRegr);
	}


}
