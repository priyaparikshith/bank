package com.example.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerAccount {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer Id;
private Integer accountNo;
private BigDecimal balance;
@ManyToOne
@JsonIgnore
@JoinColumn(name = "id")
private Customer customer;
@OneToMany(mappedBy="customerAccount",cascade= CascadeType.ALL)
private List<Payee> payees = new ArrayList<Payee>();
}
