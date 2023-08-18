package com.example.msa_example.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.msa_example.data.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    String userid;

    String userpassword;

    String username;

    Integer userage;

    public UserDto toDto()
    {
        return UserDto.builder()
        .userid(userid)
        .userpassword(userpassword)
        .username(username)
        .userage(userage)
        .build();
    }
}
