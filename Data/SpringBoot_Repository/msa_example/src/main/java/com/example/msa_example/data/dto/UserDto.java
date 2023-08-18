package com.example.msa_example.data.dto;

import com.example.msa_example.data.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    
    private String userid;
    private String userpassword;
    private String username;
    private int userage;

    public User toEntity()
    {
        return User.builder()
        .userid(userid)
        .userpassword(userpassword)
        .username(username)
        .userage(userage)
        .build();
    }
}
