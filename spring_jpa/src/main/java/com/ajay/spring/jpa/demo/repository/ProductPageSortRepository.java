package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductPageSortRepository extends PagingAndSortingRepository<Product, Integer> {


}
