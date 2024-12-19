package com.example.FirstApp.service;

import com.example.FirstApp.DTO.StudentDTO;
import com.example.FirstApp.mapper.StudentMapper;
import com.example.FirstApp.model.Student;
import com.example.FirstApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class StudentImplement implements  StudentService{
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    @Autowired

    public StudentImplement(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public Flux<StudentDTO> getAllStudents() {
//        List<Student> students = studentRepository.findAll(); // Fetch all students from the repository
//        List<StudentDTO> studentDTOs = students.stream()      // Convert the list to a stream
//                .map(studentMapper::toDto)                    // Map each Student to a StudentDTO
//                .collect(Collectors.toList());                // Collect the results into a list
//        return studentDTOs;
//  .map(student -> studentMapper.toDto(student)) hdhi lambda expression
        //ou
        //Flux<Student> students = studentRepository.findAll();
        //students.subscribe(studentMapper::toDto) //
        return studentRepository.findAll().map(studentMapper::toDto);
    }

    @Override
    public Mono<StudentDTO> saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);

        // Save the student entity to the database and return the saved student as DTO
        return studentRepository.save(student)    // Save the student
                .map(studentMapper::toDto);
//         studentRepository.save(studentMapper.toEntity(studentDTO));
//       return Mono.just(studentDTO);
    }
}
