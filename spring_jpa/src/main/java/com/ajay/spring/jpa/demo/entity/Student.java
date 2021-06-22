package com.ajay.spring.jpa.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    //It is imp that we use strategy as 'IDENTITY' here,. If we use 'AUTO' an error comes like "hibernate_sequence is not a sequence in postgres
    // In Postgres, it expects a table 'hibernate_sequnce' in case of AUTO
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "lname")
    private String lastName;

    @Column(name = "fname")
    private String firstName;

    private int score;
}
