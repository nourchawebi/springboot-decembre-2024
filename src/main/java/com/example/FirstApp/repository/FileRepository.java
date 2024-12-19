package com.example.FirstApp.repository;

import com.example.FirstApp.model.File;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileRepository extends MongoRepository<File, String> {
    Optional<File> findById(String id);
    Optional<File> findFileByFilename(String filename);
    boolean existsByFilename(String filename);
}
