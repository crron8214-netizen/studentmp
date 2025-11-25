package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.University;
import com.example.demo.studentRepository.StudentRepository;
import com.example.demo.universityRepository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> searchByName(String name) {
        List<Student> result = studentRepository.findByFirstNameContainingIgnoreCase(name);
        result.addAll(studentRepository.findByLastNameContainingIgnoreCase(name));
        return result;
    }

    public List<Student> getStudentsByUniversityName(String universityName) {
        University uni = universityRepository.findByName(universityName);
        return (uni != null) ? studentRepository.findByUniversity(uni) : List.of();
    }

    public Student assignStudentToUniversity(int studentId, int universityId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<University> uniOpt = universityRepository.findById(universityId);
        if (studentOpt.isPresent() && uniOpt.isPresent()) {
            Student s = studentOpt.get();
            s.setUniversity(uniOpt.get());
            return studentRepository.save(s);
        }
        throw new RuntimeException("Student or University not found");
    }
}
