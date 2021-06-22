package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
