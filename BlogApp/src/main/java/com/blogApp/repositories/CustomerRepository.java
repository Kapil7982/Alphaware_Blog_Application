package com.blogApp.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blogApp.models.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	public Optional<Customer> findByEmail(String email);
}
