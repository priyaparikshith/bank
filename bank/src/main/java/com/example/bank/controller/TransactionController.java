package com.example.bank.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.model.Customer;
import com.example.bank.model.CustomerAccount;
import com.example.bank.model.Payee;
import com.example.bank.model.Transaction;
import com.example.bank.respository.CustomerAccountRepository;
import com.example.bank.respository.CustomerRepository;
import com.example.bank.respository.PayeeRepository;

@RestController
public class TransactionController {
	@Autowired
	PayeeRepository payeeRepository;
	
	
	
	@Autowired
	CustomerAccountRepository customerAccountRepository;
	

	@PostMapping("/Customer/{id}/transfer/{payeeNickName}")
	private boolean amountTransfer(@PathVariable Integer id,@PathVariable String payeeNickName,@RequestBody Transaction trans) {
		Payee p = payeeRepository.findByNickName(payeeNickName);
		if ( null != p) {
		// transfer to payee account	
			CustomerAccount payeeAccount = customerAccountRepository.findByAccountNo(p.getAccountNumber());
			
			CustomerAccount cusAcc = customerAccountRepository.findByAccountNo(id);
			cusAcc.setBalance(cusAcc.getBalance().add(trans.getAmount().negate()));
			payeeAccount.setBalance(payeeAccount.getBalance().add(trans.getAmount()));
			
			customerAccountRepository.saveAll(Arrays.asList(cusAcc,payeeAccount));
			// every transaction is an entry - need to log to transaction table.
			//need to make it atomic
			return true;
		}
		
		
		
		return false;
	}
}
