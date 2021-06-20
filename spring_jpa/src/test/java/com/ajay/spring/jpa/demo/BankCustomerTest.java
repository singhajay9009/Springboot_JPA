package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.bank_tablePerClass.BankCustomer;
import com.ajay.spring.jpa.demo.entity.bank_tablePerClass.PrivilegedCustomer;
import com.ajay.spring.jpa.demo.entity.bank_tablePerClass.RegularCustomer;
import com.ajay.spring.jpa.demo.repository.BankCustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BankCustomerTest {

    @Autowired
    BankCustomerRepository bankCustomerRepository;

    @Test
    public void testCreateBankCustomer(){

        RegularCustomer regularCustomer = new RegularCustomer();
        regularCustomer.setId(104);
        regularCustomer.setCustomerType("Regular");
        regularCustomer.setName("Matt");
        regularCustomer.setAccountNumber(990888);

        bankCustomerRepository.save(regularCustomer);


        PrivilegedCustomer privilegedCustomer = new PrivilegedCustomer();
        privilegedCustomer.setId(105);
        privilegedCustomer.setCustomerType("Privileged");
        privilegedCustomer.setName("Oma");
        privilegedCustomer.setAccountNumber(5437542);

        bankCustomerRepository.save(privilegedCustomer);

    }

}
