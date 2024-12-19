package com.example.FirstApp.service;

import com.example.FirstApp.DTO.StudentDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface  StudentService {
    Flux<StudentDTO> getAllStudents();
    Mono<StudentDTO> saveStudent(StudentDTO studentDTO);
}
