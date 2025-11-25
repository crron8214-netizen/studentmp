package com.example.demo.controller;

import com.example.demo.model.University;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<University> getAll() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public Optional<University> getById(@PathVariable int id) {
        return universityService.getUniversityById(id);
    }

}
