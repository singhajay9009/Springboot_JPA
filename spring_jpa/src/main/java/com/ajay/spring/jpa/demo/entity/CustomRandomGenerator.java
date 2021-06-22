package com.ajay.spring.jpa.demo.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

/*
Class implements IdentifierGenerator to create a custom generator
 */

public class CustomRandomGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Random random = new Random();
        int id = random.nextInt(10000);
        return id;
    }
}
