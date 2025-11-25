package com.example.demo.studentRepository;

import com.example.demo.model.Student;
import com.example.demo.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstNameContainingIgnoreCase(String firstName);
    List<Student> findByLastNameContainingIgnoreCase(String lastName);
    List<Student> findByUniversity(University university);
    List<Student> findByEmailContainingIgnoreCase(String email);
}
