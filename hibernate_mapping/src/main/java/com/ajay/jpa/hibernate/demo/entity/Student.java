package com.ajay.jpa.hibernate.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

    @Id
    @Column(name = "student_id", nullable = false)
    private int studentId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Column(name = "hobbies")
    private String hobbies;
}