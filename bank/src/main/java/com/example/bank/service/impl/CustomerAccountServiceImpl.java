package com.example.bank.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.model.CustomerAccount;
import com.example.bank.model.Payee;
import com.example.bank.respository.CustomerAccountRepository;
import com.example.bank.service.CustomerAccountService;
import com.example.bank.service.PayeeService;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

	@Autowired
	CustomerAccountRepository customerAccountRepository;
	
	@Autowired
	PayeeService payeeService;
	
	@Override
	public CustomerAccount createCustomerAccount(CustomerAccount customerAccount) {
		customerAccountRepository.save(customerAccount);
		return customerAccount;
	}

	@Override
	public CustomerAccount getByAccountNumber(Integer accountNo) {
		CustomerAccount acc= customerAccountRepository.findByAccountNo(accountNo);
		return acc;
	}

	@Override
	public void deleteCustomerAccount(CustomerAccount customerAccount) {
		customerAccountRepository.delete(customerAccount);
		
	}

	@Override
	public CustomerAccount updateBalance(Integer accountNo,BigDecimal balance) {
		CustomerAccount acc = getByAccountNumber(accountNo);
		acc.setBalance(balance);
		customerAccountRepository.save(acc);
		return acc;
	}

	@Override
	public CustomerAccount addPayee(Payee payee, CustomerAccount customerAccount) {
		Payee createdPayee = payeeService.addPayee(payee);
		List<Payee> payees = customerAccount.getPayees();
		payees.add(createdPayee);
		customerAccountRepository.save(customerAccount);
		return customerAccount;
	}

	@Override
	public CustomerAccount deletePayee(String nickName,Integer accountNumber) {
	CustomerAccount custAcc = customerAccountRepository.findByAccountNo(accountNumber);
	if( null!= custAcc ) {
		List<Payee> payees = custAcc.getPayees();
		payees.stream().filter(n -> n.getNickName().equalsIgnoreCase(nickName)).forEach(m -> {payees.remove(m);});
		customerAccountRepository.save(custAcc);
		return custAcc;
	}
		return null;
	}

}
