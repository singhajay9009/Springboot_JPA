package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.payment.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
