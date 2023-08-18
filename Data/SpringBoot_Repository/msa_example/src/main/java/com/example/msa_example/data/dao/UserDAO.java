package com.example.msa_example.data.dao;

import com.example.msa_example.data.entity.User;

public interface UserDAO {
    
    User CreateUser(User user);

    User GetUser(String userid);

}
