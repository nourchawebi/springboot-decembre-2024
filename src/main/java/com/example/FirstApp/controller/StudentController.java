package com.example.FirstApp.controller;

import com.example.FirstApp.DTO.StudentDTO;
import com.example.FirstApp.service.StudentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public Flux<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping()
    public Mono<StudentDTO> saveStudent(@RequestBody StudentDTO student) {
        return studentService.saveStudent(student);
    }
}
