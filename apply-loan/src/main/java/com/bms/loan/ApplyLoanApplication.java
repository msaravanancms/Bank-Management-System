package com.bms.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.bms.loan.audit.AuditorAwareImpl;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class ApplyLoanApplication extends SpringBootServletInitializer {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(ApplyLoanApplication.class, args);
	}

}
