package com.ajay.spring.jpa.demo.entity.payment;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("ch")
public class Check extends Payment{

    private String checkNumber;
}
