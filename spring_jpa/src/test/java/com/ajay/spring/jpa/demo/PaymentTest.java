package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.payment_singleTable.CreditCard;
import com.ajay.spring.jpa.demo.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    public void createPayment(){

        CreditCard creditCard = new CreditCard();
        creditCard.setId(1);
        creditCard.setAmount(23.56);
        creditCard.setCardNumber("1234567");

        paymentRepository.save(creditCard);
    }
}
