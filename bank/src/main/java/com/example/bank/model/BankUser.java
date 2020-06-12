package com.example.bank.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankUser {
 @Id
 private Integer id;
 private String userName;
 private String password;
 private Timestamp createdDate;
 private Timestamp lastUpdatedDate;
 private Timestamp status;
	
}
