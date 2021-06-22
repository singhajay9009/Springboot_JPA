package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.relationship.manyToOne_Unidir.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
}
