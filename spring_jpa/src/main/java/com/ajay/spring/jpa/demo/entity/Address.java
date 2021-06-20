package com.ajay.spring.jpa.demo.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String street;
    private String city;
    private int zip;
    private String country;
}
