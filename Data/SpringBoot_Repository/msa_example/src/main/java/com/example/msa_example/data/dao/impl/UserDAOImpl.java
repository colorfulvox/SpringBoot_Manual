package com.example.msa_example.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msa_example.data.dao.UserDAO;
import com.example.msa_example.data.entity.User;
import com.example.msa_example.data.repository.UserRepository;

@Service
public class UserDAOImpl implements UserDAO {
    
    UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User CreateUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User GetUser(String userid) {
        User user = userRepository.getById(userid);
        return user;
    }



}
