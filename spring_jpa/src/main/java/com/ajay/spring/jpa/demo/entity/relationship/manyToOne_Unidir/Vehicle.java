package com.ajay.spring.jpa.demo.entity.relationship.manyToOne_Unidir;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Vehicle {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String company;

    @ManyToOne(cascade = CascadeType.ALL) // if we dont enable cascade option here , then
    // we first need to persist owner and then vehicle.
    // Refer OwnerTest -> testCreateOwnerVehicle()
    // By enabling Cascade option we can directly Save Vehicle. It will first save Owner and then Vehicle
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;
}
