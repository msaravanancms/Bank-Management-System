package com.bms.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bms.customer.audit.AuditorAwareImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
@EnableSwagger2
public class RegistrationLoginSpringBootApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginSpringBootApplication.class, args);
	}

}
