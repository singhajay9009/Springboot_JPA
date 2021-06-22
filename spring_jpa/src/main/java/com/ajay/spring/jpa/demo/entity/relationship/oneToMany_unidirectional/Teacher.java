package com.ajay.spring.jpa.demo.entity.relationship.oneToMany_unidirectional;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter @Getter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @OneToMany(cascade = CascadeType.ALL)  //fetch type All will ensure child is loaded as soon as parent is loaded
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Set<Course> courses;
}
