package com.example.FirstApp.mapper;


import com.example.FirstApp.DTO.StudentDTO;
import com.example.FirstApp.model.Student;
import org.mapstruct.Mapper;

@Mapper
    public interface StudentMapper{

        StudentDTO toDto(Student student);
        Student toEntity(StudentDTO studentDTO);
    }

