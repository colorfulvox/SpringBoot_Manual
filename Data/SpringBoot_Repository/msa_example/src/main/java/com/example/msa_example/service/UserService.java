package com.example.msa_example.service;

import com.example.msa_example.data.dto.UserDto;

public interface UserService {
    UserDto CreateUser(String userid,String password,String username, int userage);

    UserDto GetUser(String userid);
}
