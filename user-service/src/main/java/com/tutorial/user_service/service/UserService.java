package com.tutorial.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.user_service.entity.User;
import com.tutorial.user_service.repository.I_UserRepository;

@Service
public class UserService {

    @Autowired
    I_UserRepository userRepository;


    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User  getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        User userNew= userRepository.save(user);
        return userNew;
    }

}
