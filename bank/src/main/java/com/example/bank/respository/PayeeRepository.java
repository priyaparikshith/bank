package com.example.bank.respository;

import org.springframework.data.repository.CrudRepository;

import com.example.bank.model.Payee;

public interface PayeeRepository extends CrudRepository<Payee, Integer> {
public Payee findByNickName(String nickName);
}
