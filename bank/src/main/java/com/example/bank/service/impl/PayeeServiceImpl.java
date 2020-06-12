package com.example.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bank.model.Payee;
import com.example.bank.respository.PayeeRepository;
import com.example.bank.service.PayeeService;

public class PayeeServiceImpl implements PayeeService {

	@Autowired
	PayeeRepository payeeRepository;
	
	
	
	@Override
	public Payee addPayee(Payee payee) {
		Payee createdPayee = payeeRepository.save(payee);
		return createdPayee;
	}

	@Override
	public boolean deletePayee(Integer payeeId) {
		Payee payee = payeeRepository.findById(payeeId).get();
		if( null != payee) {
		 payeeRepository.deleteById(payeeId);
		 return true;
		}
		return false;
	}

}
