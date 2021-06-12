package com.ajay.spring.jpa.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



/*
This class is created to test ID generation strategies
 */


@Entity
@Table(name = "employee_id")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private int id;


//    @Id
//    @TableGenerator(name="emp_gen",table = "id_gen", pkColumnName = "gen_name", pkColumnValue = "next_val", allocationSize=100)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "emp_gen")
//    private int id;

    @Id
    @GenericGenerator(name = "generic_gen", strategy = "com.ajay.spring.jpa.demo.entity.CustomRandomGenerator")
    @GeneratedValue(generator= "generic_gen")
    private int id;

    private String name;
}
