package com.bms.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.customer.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long>{

}
