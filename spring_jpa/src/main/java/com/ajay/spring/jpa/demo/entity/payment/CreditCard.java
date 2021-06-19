package com.ajay.spring.jpa.demo.entity.payment;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("cc")
public class CreditCard extends Payment {

    private String cardNumber;
}
