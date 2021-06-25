package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.manyToMany.Programmer;
import com.ajay.spring.jpa.demo.entity.relationship.manyToMany.Project;
import com.ajay.spring.jpa.demo.repository.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
public class ProgrammerProjectTest {
    @Autowired
    ProgrammerRepository programmerRepository;


    @Test
    public void testCreateProgProj(){
        Programmer programmer = new Programmer();
        programmer.setName("Robert");

        Project proj1 = new Project();
        proj1.setName("Neutron bodies");

        Project proj2 = new Project();
        proj2.setName("Bacterial inflammation");

        programmer.setProjects(new HashSet<>(Arrays.asList( proj1, proj2)));

        programmerRepository.save(programmer);


    }

    @Test
    @Transactional
    public void testFetchProgrammerProject(){
        Programmer programmer = programmerRepository.findById(1).get();

        System.out.println(programmer);

        programmer.getProjects().forEach(System.out::println);

    }

}
