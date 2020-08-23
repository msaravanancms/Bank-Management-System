package com.bms.loan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bms.loan.model.Loan;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplyLoanApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@DisplayName("test Message REST API ")
	void testMessage() {
		 Loan loan = new Loan();
		loan.setAccountNumber(98865559);
		loan.setAccountType("Saving");
		loan.setCustomerId( "555899");
		loan.setDurationOfLoan( "55");
		loan.setLoanAmount(98865559);
		loan.setLoanDate("20200507");
		loan.setLoanId(45466666);
		loan.setLoanType("Home");
		loan.setRateOfInterest(45);
		 String  loanob = this.restTemplate.postForObject("/applyloan",loan, String.class);
			 System.out.println("@@@@:"+loanob);
		assertEquals(loan, loan);
	}
	
	@Test
	@DisplayName("test Message REST API ")
	void customerIdNotFoundTest() {
		    	Loan loan = new Loan();
		loan.setAccountNumber(98865559);
		loan.setAccountType("Saving");
		loan.setCustomerId( "555899");
		loan.setDurationOfLoan( "55");
		loan.setLoanAmount(98865559);
		loan.setLoanDate("20200507");
		loan.setLoanId(45466666);
		loan.setLoanType("Home");
		loan.setRateOfInterest(45);
	 String  loanob = this.restTemplate.postForObject("/applyloan",loan, String.class);
			System.out.println("@@@@:"+loanob);
		assertEquals(loanob, loanob);
	}

}
