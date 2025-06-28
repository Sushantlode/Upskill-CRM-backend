package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // 🔹 Create
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student saved = service.createStudent(student);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 🔹 Read All
    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // 🔹 Read One
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // 🔹 Update
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Student updated = service.updateStudent(id, student);
        return ResponseEntity.ok(updated);
    }

    // 🔹 Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    
}
