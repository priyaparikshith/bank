package com.example.bank.service;

import org.springframework.stereotype.Service;

import com.example.bank.model.CustomerAccount;
import com.example.bank.model.Payee;

@Service
public interface PayeeService {
public Payee addPayee(Payee payee);
public boolean deletePayee(Integer payeeId);
	
}
