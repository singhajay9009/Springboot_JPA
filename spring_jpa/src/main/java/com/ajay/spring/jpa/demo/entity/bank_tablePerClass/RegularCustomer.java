package com.ajay.spring.jpa.demo.entity.bank_tablePerClass;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "regular_customer")
public class RegularCustomer extends BankCustomer {

    @Column(name = "account_number")
    private int accountNumber;

    private String name;
}
