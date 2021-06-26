package com.ajay.spring.jpa.demo.entity.relationship.manyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<Programmer> programmers;


//    public void addProgrammer(Programmer programmer) {
//        programmers.add(programmer);
//        programmer.getProjects().add(this);
//    }
//
//    public void removeProgrammer(Programmer programmer) {
//        programmers.remove(programmer);
//        programmer.getProjects().remove(this);
//    }
//
//    public void remove() {
//        for(Programmer programmer : new HashSet<>(programmers)) {
//            removeProgrammer(programmer);
//        }
//    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
