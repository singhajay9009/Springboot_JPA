package com.ajay.jpa.hibernate.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
 //   @SequenceGenerator(name="seq",sequenceName="emp_id_seq")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "emp_id", nullable = false)
    private int emp_id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Column(name = "hobbies")
    private String hobbies;
}
