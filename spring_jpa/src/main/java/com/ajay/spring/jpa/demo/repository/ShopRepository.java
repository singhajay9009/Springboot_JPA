package com.ajay.spring.jpa.demo.repository;


import com.ajay.spring.jpa.demo.entity.bank_joinedTable.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
}
