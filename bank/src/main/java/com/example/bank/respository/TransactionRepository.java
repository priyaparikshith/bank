package com.example.bank.respository;
import org.springframework.data.repository.CrudRepository;

import com.example.bank.model.Transaction;

public interface TransactionRepository  extends CrudRepository<Transaction, Integer> {

}
