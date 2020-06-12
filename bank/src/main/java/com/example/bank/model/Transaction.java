package com.example.bank.model;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.annotation.Reference;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
public class Transaction {
	@Id
	private Integer id;
	private Integer accountNumber;
	@JsonIgnore
	private Timestamp date;
	@JsonIgnore
	private String transactionType;
	@JsonIgnore @Transient
	private Payee payeeTransfer;
	private String payeeNickName;
	private BigDecimal amount;
	private String comments;
	
}
