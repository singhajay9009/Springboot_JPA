package com.ajay.spring.jpa.demo.repository;

import com.ajay.spring.jpa.demo.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("from Student")
    List<Student> findAllStudents();

    @Query("Select s.firstName, s.lastName from Student s")
    List<Object[]> findAllStudentsPartialColumns();

    @Query("from Student where firstName=:firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score>:start And score<:end")
    List<Student> findAllStudentsByRange(@Param("start") int start, @Param("end") int end);

    @Modifying
    @Transactional
    @Query("delete from Student where firstName=:name")
    void deleteStudent(@Param("name") String firstName);

    @Query(value = "Select * from student", nativeQuery = true)
    List<Student> findAllStudentsUsingNativeQuery();

}
