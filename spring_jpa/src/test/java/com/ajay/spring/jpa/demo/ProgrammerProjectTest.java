package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.manyToMany.Programmer;
import com.ajay.spring.jpa.demo.entity.relationship.manyToMany.Project;
import com.ajay.spring.jpa.demo.repository.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
public class ProgrammerProjectTest {
    @Autowired
    ProgrammerRepository programmerRepository;

    @Autowired
    ProjectRepository projectRepository;


    @Test
    public void testCreateProgProj(){
        Programmer programmer = new Programmer();
        programmer.setName("Ethan");

        Project proj1 = new Project();
        proj1.setName("Wireless Transmission");

        Project proj2 = new Project();
        proj2.setName("Ocean Energy");

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

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteProgrammerProject(){
        Programmer programmer = programmerRepository.findById(1).get();

        System.out.println(programmer);

        programmer.getProjects().removeAll(programmer.getProjects());

        //It will delete programmer from 'programmer' tbl, and associated mapping from 'programmer_project' tbl
        // It would not delte anything from project tbl, as expected as those projects might be associated with other programmers as well
        programmerRepository.delete(programmer);
    }

}
