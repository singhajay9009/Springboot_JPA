package com.ajay.spring.jpa.demo.entity.payment_singleTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cc")
@Setter
@Getter
public class CreditCard extends Payment {

    @Column(name = "cardnumber")
    private String cardNumber;
}
