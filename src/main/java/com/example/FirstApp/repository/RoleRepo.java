package com.example.FirstApp.repository;

import com.example.FirstApp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
