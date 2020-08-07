package com.bms.customer.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bms.customer.exception.ResourceNotFoundException;
import com.bms.customer.model.Account;
import com.bms.customer.model.Customer;
import com.bms.customer.model.Role;
import com.bms.customer.model.User;
import com.bms.customer.repository.CustomerRepository;
import com.bms.customer.repository.UserRepository;
import com.bms.customer.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserRepository userRepository;
	@Autowired
	private CustomerRepository  customRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getCustomerId(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
		Customer customer = new Customer();
		System.out.println("$$$$$$$ registrationDto:"+registrationDto.getCustomerId());
		customer.setCustomerName(registrationDto.getFirstName());
		customer.setAddress(registrationDto.getAddress());
		customer.setPassword(registrationDto.getPassword());
		customer.setCustomerId(registrationDto.getCustomerId());
		customer.setEmail(registrationDto.getEmail());
		customer.setState(registrationDto.getCountry());
		customer.setCountry(registrationDto.getState());

		Account acc = new Account();
		acc.setAccountName(registrationDto.getAccountName());
		acc.setAccountNumber(registrationDto.getAccountNumber());
		acc.setAccountType(registrationDto.getAccountType());
		acc.setDob(registrationDto.getDob());
		acc.setPanNumber(registrationDto.getPanNumber());
		acc.setCustomerId(registrationDto.getCustomerId());
		customer.setAccount(acc);
		// accountRepository.save(acc);
		customRepository.save(customer);
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String customerId) throws UsernameNotFoundException {
	
		User user = userRepository.findByCustomerId(customerId);
		if(user == null) {
			logger.error("Invalid username or password");
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getCustomerId(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
