package com.jpa.h2.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;


@Data
@Builder
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name= "hobby")
    private String hobby;

    @Column(name = "laptop_id")
    private Long laptopId;

    @OneToOne(mappedBy = "student")
    private Laptop laptop;

}
