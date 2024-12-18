package com.example.FirstApp.controllers;


import com.example.FirstApp.entities.UserEntity;
import com.example.FirstApp.services.UserInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Combine @Controller et @ResponseBody pour une API REST
//@Controller
@RequestMapping("/user") // Définit une base d'URL pour ce contrôleur
public class UserController {
@Autowired
    UserInterface userInterface;
    @GetMapping("/test")
    //@ResponseBody

    public String test(){

        return "Hey user";

    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getUser() {
        Map<String,Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", "User details here");

        return ResponseEntity.ok(response);
    }
   @PostMapping("/add")
    public UserEntity addUser(@RequestBody UserEntity user)
   {

       return userInterface.addUser(user);
   }

@DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userInterface.deleteUser(id);
}
    @DeleteMapping("/deleteuser")
    public void deleteUsers(@RequestParam Long id){
        userInterface.deleteUser(id);
    }
    @PostMapping("addlistusers")
    public List<UserEntity> addlistusers(@RequestBody List<UserEntity> users)
    {
        return userInterface.addListUsers(users);
    }
    @PostMapping("/addwithconfpassword")
    public String addUserWTCP(@RequestBody UserEntity user)
    {

        return userInterface.addUserWTCP(user);
    }

    @PostMapping("/adduserWTUN")
    public String addUserWTUN(@RequestBody UserEntity user)
    {
        return userInterface.addUserWTUN(user);
    }
    @PutMapping("/updateuser/{ids}")
    public UserEntity updateuser(@PathVariable("ids")Long id,@RequestBody UserEntity user)
    {return userInterface.updateUser(id,user);}
   @GetMapping("/getAllusers")
    public   List<UserEntity> getAllUsers()
   {
       return userInterface.getAllusers();
   }
   @GetMapping("getUserById/{id}")
    public UserEntity getUserById(@PathVariable Long id)
   {
       return userInterface.getUser(id);
   }
    @GetMapping("getUserByUN/{un}")
    public UserEntity getUserByUsername(@PathVariable String un)
    {
        return userInterface.getuserByUsername(un);
    }
    @GetMapping("getUsersSWuN/{un}")
    public   List<UserEntity> getUsersSW(@PathVariable String un)
    {
        return userInterface.getUsersSW(un);
    }
    @GetMapping("/getUsersByEmail")
    public  List<UserEntity> getUsersByEmail(@RequestParam String email)
    {
        return userInterface.getUsersByEmail(email);
    }
}
