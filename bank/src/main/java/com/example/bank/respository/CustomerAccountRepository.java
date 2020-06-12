package com.example.bank.respository;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.model.CustomerAccount;

public interface CustomerAccountRepository extends CrudRepository<CustomerAccount, Integer> {
public CustomerAccount findByAccountNo(Integer accountNumber);

}
