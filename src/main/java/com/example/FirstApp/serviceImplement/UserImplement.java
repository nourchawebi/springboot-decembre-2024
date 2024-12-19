package com.example.FirstApp.serviceImplement;

import com.example.FirstApp.entities.Role;
import com.example.FirstApp.entities.UserEntity;
import com.example.FirstApp.repository.RoleRepo;
import com.example.FirstApp.repository.UserRepo;
import com.example.FirstApp.services.UserInterface;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplement implements UserInterface {

    @Autowired
    UserRepo userRepository;
    @Autowired
    RoleRepo roleRepository;
    @Override
    public UserEntity addUser(UserEntity user) {
        Role defaulRole= roleRepository.findById(1L).orElse(null);

        user.getRole().add(defaulRole);
        return  userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> addListUsers(List<UserEntity> listusers) {
        return userRepository.saveAll(listusers);
    }
    @Override
    public String addUserWTCP(UserEntity user)
    {
        String ch ="";
        if(user.getPassword().equals(user.getConfPassword()))
        {
userRepository.save(user);
ch="user added successfuly";

        }
        else
        {
            ch="check conf password!" ;
        }
        return ch ;
    }

    @Override
    public String addUserWTUN(UserEntity user) {
        String ch="";
        if(userRepository.existsByUsername(user.getUsername()))
        {
            ch=" user already exists";
        }else {
            userRepository.save(user);
            ch="user added !!" ;
        }
        return ch;
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {

        UserEntity usr= userRepository.findById(id).get();
        usr.setFirstName(user.getFirstName());
        usr.setLastName((user.getLastName()));
        return userRepository.save(usr);
    }

    @Override
    public List<UserEntity> getAllusers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElse(null);

    }

    @Override
    public UserEntity getuserByUsername(String un) {
        return userRepository.findByUsername(un);
    }

    @Override
    public List<UserEntity> getUsersSW(String un) {
        return userRepository.getUserSW(un);
    }

    @Override
    public List<UserEntity> getUsersByEmail(String un) {
        return userRepository.getUsersByEmail(un);
    }
}
