package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.relationship.oneToOne.Person2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person2, Integer> {
}
