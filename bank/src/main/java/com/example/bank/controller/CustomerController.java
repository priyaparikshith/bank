package com.example.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Customer;
import com.example.bank.model.CustomerAccount;
import com.example.bank.respository.CustomerAccountRepository;
import com.example.bank.respository.CustomerRepository;
import com.example.bank.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerAccountController customerAccountController;

	@PostMapping
	private Customer createCustomer(@RequestBody Customer cust) {
			return customerService.addCustomer(cust);// will save customeraccount too?
	}

	@GetMapping("/{userName}")
	private Customer getCustomerByUserName(@PathVariable String userName) {
		return customerService.getCustomerByUserName(userName);
		 
	}

	@GetMapping
	private List<Customer> getAllCustomers() {
		return customerService.getCustomers();
		
	}
	
	
	

	@PatchMapping("/{userName}/createAccount")
	private Customer createCustomerAccount(@RequestBody CustomerAccount custAcc, @PathVariable String userName) {
		Customer cust = customerService.getCustomerByUserName(userName);
		CustomerAccount account = customerAccountController.createCustomerAccount(custAcc);
		cust.getAccounts().add(account);
		return customerService.saveCustomer(cust);
		
	}
	
	@PatchMapping("/{userName}/accountNumber")
	private Customer addPayee(@RequestBody CustomerAccount custAcc, @PathVariable Integer accountNumber) {
		Customer cust = customerService.getCustomerByUserName(userName);
		CustomerAccount account = customerAccountController.createCustomerAccount(custAcc);
		cust.getAccounts().add(account);
		return customerService.saveCustomer(cust);
		
	}

}
