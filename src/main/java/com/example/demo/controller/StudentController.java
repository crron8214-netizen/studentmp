package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students") 
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addOrUpdateStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully.";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @GetMapping("/by-university")
    public List<Student> getByUniversity(@RequestParam String universityName) {
        return studentService.getStudentsByUniversityName(universityName);
    }

    @PostMapping("/{studentId}/assign-university/{universityId}")
    public Student assignToUniversity(@PathVariable int studentId, @PathVariable int universityId) {
        return studentService.assignStudentToUniversity(studentId, universityId);
    }
}
