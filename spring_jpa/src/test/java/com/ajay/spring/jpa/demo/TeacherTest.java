package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.oneToMany_unidirectional.Course;
import com.ajay.spring.jpa.demo.entity.relationship.oneToMany_unidirectional.Teacher;
import com.ajay.spring.jpa.demo.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class TeacherTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void testCreateTeacherCourses(){
        Course course = new Course();
        course.setTitle("Medical");

        Course course1 = new Course();
        course1.setTitle("Sports");

        Set<Course> courseSet = new HashSet<>(Arrays.asList(course, course1));

        Teacher teacher = new Teacher();
        teacher.setName("Anna");
        teacher.setAge(24);
        teacher.setCourses(courseSet);

        teacherRepository.save(teacher);

    }

    @Test
    @Transactional // This annotation is required to tell springboot that it is a transaction
    // and Springboot will ensure to make the fetch work even with default 'Lazy loading' of Course objects
    // If we remove @Transactional, it will fail and give error
    // The other way is enable fetch = FETCHTYPE.EAGER in @OneToMany in Teacher entity.;
    public void testFetchTeacherCourses() {
        teacherRepository.findAll().forEach(p -> p.getCourses().forEach(c -> System.out.println(c.getTitle())));
    }
}
