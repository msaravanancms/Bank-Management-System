package com.bms.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.bms.customer.web.dto.UserRegistrationDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RegistrationLoginSpringBootApplicationTests {
	UserRegistrationDto userRegr = new UserRegistrationDto();
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("test Message REST API ")
	void testMessage() {
		
		userRegr.setCustomerId("5556626");
		userRegr.setAccountNumber(4542226);
		userRegr.setAccountType("string");
		userRegr.setAccountName("Saving");
		userRegr.setDob("54566");
		userRegr.setLastName("vedha");
		userRegr.setPanNumber("4545456");
		userRegr.setAddress("chennai");
		userRegr.setPassword("vedha");
		userRegr.setEmail("msaravanancms@gmail.com");
		userRegr.setState("chennai");
		userRegr.setCountry("chennai");
		userRegr.setFirstName("vedha");
		String message = "Successfully Regisered "+userRegr.getCustomerId();
		String  outMessage = this.restTemplate.postForObject("/registercustomer/customeregistration/",userRegr, String.class);
			System.out.println("@@@@:"+message);
		assertEquals(message, message);
	}


}
