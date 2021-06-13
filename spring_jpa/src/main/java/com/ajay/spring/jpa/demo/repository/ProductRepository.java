package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Optional<List<Product>> findByPrice(Double price);

    List<Product> findByName(String name);

    Optional<List<Product>> findByNameAndPrice(String name, Double price);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double p1, Double p2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids);

    // You can also define a pageable param in custom find method and it would serve for paging and Sorting
    List<Product> findByNameIn(List<String> names, Pageable pageable);

}
