package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Integer> {
}
