package com.ajay.spring.jpa.demo.entity.relationship.oneToOne;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter @Getter
public class License2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @Column(name = "valid_from")
    private LocalDate fromDate;

    @Column(name = "valid_to")
    private LocalDate toDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person2 person;
}
