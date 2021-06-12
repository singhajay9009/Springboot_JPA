package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
