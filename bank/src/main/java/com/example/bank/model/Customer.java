package com.example.bank.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String firstName;
private String lastName;
private String emailId;
private Long contactNumber;
private String userName;
@OneToMany(mappedBy="customer", cascade= CascadeType.ALL)
private List<CustomerAccount> accounts = new ArrayList<CustomerAccount>();

}
