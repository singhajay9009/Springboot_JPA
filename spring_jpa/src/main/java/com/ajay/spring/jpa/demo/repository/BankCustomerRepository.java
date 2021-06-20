package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.bank_tablePerClass.BankCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCustomerRepository extends CrudRepository<BankCustomer, Integer> {
}
