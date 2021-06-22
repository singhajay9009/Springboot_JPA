package com.ajay.spring.jpa.demo.entity.payment_singleTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
@Setter @Getter
public class Check extends Payment{

    @Column(name = "checknumber")
    private String checkNumber;
}
