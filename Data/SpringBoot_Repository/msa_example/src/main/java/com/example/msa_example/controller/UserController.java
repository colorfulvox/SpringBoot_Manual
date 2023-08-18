package com.example.msa_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.msa_example.data.dto.UserDto;
import com.example.msa_example.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/user/createuser")
    public ResponseEntity<UserDto> CreateUser(@Validated @RequestBody UserDto userDto)
    {
        String userid = userDto.getUserid();
        String userpassword = userDto.getUserpassword();
        String username = userDto.getUsername();
        int userage = userDto.getUserage();
        
        UserDto res = userService.CreateUser(userid, userpassword, username, userage);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping(value = "/user/getuser/{userid}")
    public ResponseEntity<UserDto> GetUser(@PathVariable String userid)
    {
        UserDto res = userService.GetUser(userid);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    
}
