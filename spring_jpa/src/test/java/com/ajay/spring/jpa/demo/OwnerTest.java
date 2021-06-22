package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.manyToOne_Unidir.Owner;
import com.ajay.spring.jpa.demo.entity.relationship.manyToOne_Unidir.Vehicle;
import com.ajay.spring.jpa.demo.repository.OwnerRepository;
import com.ajay.spring.jpa.demo.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class OwnerTest {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    public void testCreateOwnerVehicle(){

        Owner owner = new Owner();
        owner.setName("Anna");

        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(owner);
        vehicle.setCompany("BMW");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setOwner(owner);
        vehicle1.setCompany("Jaguar");

        ownerRepository.save(owner);
        vehicleRepository.saveAll(Arrays.asList(vehicle, vehicle1));
    }

    @Test
    public void testFetchOwnerVehicle(){
        vehicleRepository.findAll().forEach(v -> System.out.println(v.getOwner().getName()));
    }

    @Test
    public void testCreateOwnerVehicle_two(){

        Owner owner = new Owner();
        owner.setName("Tobi");

        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(owner);
        vehicle.setCompany("Hyundai");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setOwner(owner);
        vehicle1.setCompany("Mini");

      //  ownerRepository.save(owner);
        vehicleRepository.saveAll(Arrays.asList(vehicle, vehicle1));
    }

}
