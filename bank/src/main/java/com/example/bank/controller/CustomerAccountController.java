package com.example.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.CustomerAccount;
import com.example.bank.service.CustomerAccountService;

@RestController
public class CustomerAccountController {
	@Autowired
	CustomerAccountService customerAccountService;
	
public CustomerAccount createCustomerAccount(CustomerAccount account) {
	CustomerAccount custAcc = customerAccountService.createCustomerAccount(account);
	return custAcc;
}
// test
	
}
