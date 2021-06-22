package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.oneToMany_unidirectional.Course;
import com.ajay.spring.jpa.demo.entity.relationship.oneToMany_unidirectional.Teacher;
import com.ajay.spring.jpa.demo.repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        course.setTitle("Data Science");

        Course course1 = new Course();
        course1.setTitle("Python");

        Set<Course> courseSet = new HashSet<>(Arrays.asList(course, course1));

        Teacher teacher = new Teacher();
        teacher.setName("Matt");
        teacher.setAge(42);
        teacher.setCourses(courseSet);

        teacherRepository.save(teacher);

    }
}
