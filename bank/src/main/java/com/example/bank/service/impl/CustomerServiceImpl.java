package com.example.bank.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.Customer;
import com.example.bank.respository.CustomerRepository;
import com.example.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	String[] ignoreAttributes = {"id","userName"};
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer customerToUpdate = customerRepository.findById(customer.getId()).get();
		BeanUtils.copyProperties(customerToUpdate, customer,ignoreAttributes);
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		customerRepository.deleteById(customerId);
		return null;
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customer = (List<Customer>)customerRepository.findAll();
		return customer;
	}

	@Override
	public Customer getCustomerByUserName(String userName) {
		Customer customer = customerRepository.findByUserName(userName);
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	

}
