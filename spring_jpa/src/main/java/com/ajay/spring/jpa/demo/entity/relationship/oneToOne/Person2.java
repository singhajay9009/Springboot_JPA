package com.ajay.spring.jpa.demo.entity.relationship.oneToOne;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Person2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")// mappedBy here determines that the relationship would be managed by other entity
    private License2 license;

}
