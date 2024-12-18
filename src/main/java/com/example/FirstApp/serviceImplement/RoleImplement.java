package com.example.FirstApp.serviceImplement;

import com.example.FirstApp.entities.Role;
import com.example.FirstApp.repository.RoleRepo;
import com.example.FirstApp.services.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleImplement implements RoleInterface {

    @Autowired
    private RoleRepo roleRepo;
    @Override
    public Role add(Role role) {
        return  roleRepo.save(role);
    }
}
