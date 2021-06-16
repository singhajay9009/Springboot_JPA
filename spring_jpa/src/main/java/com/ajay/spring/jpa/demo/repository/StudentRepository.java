package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Integer, Student> {


}
