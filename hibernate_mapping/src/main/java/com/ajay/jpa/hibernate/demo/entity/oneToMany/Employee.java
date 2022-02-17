package com.ajay.jpa.hibernate.demo.entity.oneToMany;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Asset> assets;
}
