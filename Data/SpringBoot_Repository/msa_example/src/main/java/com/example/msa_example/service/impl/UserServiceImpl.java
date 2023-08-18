package com.example.msa_example.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msa_example.data.dao.UserDAO;
import com.example.msa_example.data.dto.UserDto;
import com.example.msa_example.data.entity.User;
import com.example.msa_example.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDto CreateUser(String userid, String password, String username, int userage) {
        User user = new User(userid, password, username, userage);
        
        userDAO.CreateUser(user);

        UserDto userDto = new UserDto(user.getUserid(), user.getUserpassword(),user.getUsername(), user.getUserage());
        return userDto;    
    }

    @Override
    public UserDto GetUser(String userid) {

        User user = userDAO.GetUser(userid);

        UserDto userDto = new UserDto(user.getUserid(), user.getUserpassword(),user.getUsername(), user.getUserage());
        return userDto;
    }
    
}
