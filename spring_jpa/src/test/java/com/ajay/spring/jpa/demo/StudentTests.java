package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.Student;
import com.ajay.spring.jpa.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class StudentTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testFindAll(){
        Student student = Student.builder()

                .firstName("Eric")
                .lastName("White")
                .score(56)
                .build();
        studentRepository.save(student);
        List<Student> students = studentRepository.findAllStudents();
        students.forEach(s -> System.out.println("Students are: " + s.getFirstName() + " " + s.getLastName()));
    }

    @Test
    public void testFindAllPartialColumnData() {
        List<Object[]> students = studentRepository.findAllStudentsPartialColumns();
        students.forEach(object ->
                System.out.println("Students are: " + "first name: " + object[0] + " == " + "last name: " + object[1]));

    }

    @Test
    public void testFinAllByFirstName(){
        Student student = Student.builder()
                .firstName("Nick")
                .lastName("Oma")
                .score(54)
                .build();
        studentRepository.save(student);
        List<Student> students = studentRepository.findAllStudentsByFirstName("Nick");
        students.forEach(s ->
                System.out.println("Students are: " + s.getId() + "==" + s.getFirstName() + "==" + s.getLastName()));

    }

    @Test
    public void testFindAllByRange(){
        Student student = Student.builder()
                .firstName("Julie")
                .lastName("Pomela")
                .score(86)
                .build();
        studentRepository.save(student);
        List<Student> students = studentRepository.findAllStudentsByRange(50, 55);
        students.forEach(s ->
                System.out.println("Students are: " + s.getId() + "==" + s.getFirstName() + "==" + s.getLastName()));
    }

    @Test
    @Rollback(false)
    public void testDeleteStudent(){
//        Student student = Student.builder()
//                .firstName("Rambo")
//                .lastName("Etala")
//                .score(23)
//                .build();
//        studentRepository.save(student);

        studentRepository.deleteStudent("Rambo");
        List<Student> students = studentRepository.findAllStudentsByFirstName("Rambo");
        students.forEach(s ->
                System.out.println("Students are: " + s.getId() + "==" + s.getFirstName() + "==" + s.getLastName()));
    }

    @Test
    public void testFindAllStudentsUsingNativeQuery(){
       List<Student> students = studentRepository.findAllStudentsUsingNativeQuery();
       students.forEach(s -> System.out.println(s));
    }


}
