package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.Address;
import com.ajay.spring.jpa.demo.entity.User;
import com.ajay.spring.jpa.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateUser(){

        Address address = Address.builder()
                .city("wyoming")
                .street("abc")
                .zip(343443)
                .country("USA")
                .build();

        User user = User.builder()
                .id(101)
                .name("Rock")
                .address(address)
                .build();

        userRepository.save(user);
    }
}
