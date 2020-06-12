package com.example.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payee {
	@Id
	private Integer id;
	private String bankName;
	private String ifscCode;
	private String accountName;
	private Integer accountNumber;
	private String name;
	private String nickName;
	@ManyToOne
	@JsonIgnore
	private Customer customerAccount;
}
