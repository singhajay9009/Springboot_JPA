package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
