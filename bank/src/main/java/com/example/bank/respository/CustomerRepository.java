package com.example.bank.respository;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	public Customer findByFirstName(String firstName);
	public Customer findByLastName(String lastName);
	public Customer findByUserName(String userName);

}
