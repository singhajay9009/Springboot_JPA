package com.ajay.jpa.hibernate.demo.entity;


import lombok.Builder;
import lombok.Data;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
@Builder
public class Employee {

    @Id
    @SequenceGenerator(name="seq",sequenceName="id_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    private String firstName;

    private String lastName;

    private LocalDate joiningDate;
}
