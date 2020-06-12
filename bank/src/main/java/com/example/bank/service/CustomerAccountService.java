package com.example.bank.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.bank.model.CustomerAccount;
import com.example.bank.model.Payee;

@Service
public interface CustomerAccountService {
	public CustomerAccount createCustomerAccount(CustomerAccount customerAccount);
	public CustomerAccount getByAccountNumber(Integer accountNo);
	public void deleteCustomerAccount(CustomerAccount customerAccount);
	public CustomerAccount updateBalance(Integer accountNo,BigDecimal balance);
	public CustomerAccount addPayee(Payee payee,CustomerAccount customerAccount);
	public CustomerAccount deletePayee(String nickName,Integer accountNumber);

}
