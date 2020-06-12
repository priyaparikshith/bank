package com.example.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bank.model.Customer;

@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Integer customerId);
	public Customer getCustomerById(Integer customerId);
	public Customer getCustomerByUserName(String userName);
	public List<Customer> getCustomers();
	public Customer saveCustomer(Customer customer);
}
