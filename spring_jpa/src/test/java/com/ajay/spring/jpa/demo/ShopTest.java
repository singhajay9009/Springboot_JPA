package com.ajay.spring.jpa.demo;


import com.ajay.spring.jpa.demo.entity.bank_joinedTable.Customer;
import com.ajay.spring.jpa.demo.entity.bank_joinedTable.EmployeeShop;
import com.ajay.spring.jpa.demo.repository.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopTest {

    @Autowired
    ShopRepository shopRepository;

    @Test
    public void testCreateShop(){

        EmployeeShop emp = new EmployeeShop();
        emp.setId(103);
        emp.setName("Ricky");
        emp.setAge(24);
        emp.setType("customer");


        Customer customer = new Customer();
        customer.setId(104);
        customer.setName("Tobi");
        customer.setAge(32);
        customer.setType("employee");

        shopRepository.save(emp);
        shopRepository.save(customer);
    }
}
