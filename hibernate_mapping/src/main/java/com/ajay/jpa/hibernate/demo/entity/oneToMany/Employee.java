package com.ajay.jpa.hibernate.demo.entity.oneToMany;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Asset> assets;
}
