package com.example.FirstApp.controllers;

import com.example.FirstApp.entities.Role;
import com.example.FirstApp.entities.UserEntity;
import com.example.FirstApp.services.RoleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleInterface roleInterface;
    @PostMapping("/add")
    public Role addRole(@RequestBody Role role)
    {

        return roleInterface.add(role);
    }
}
