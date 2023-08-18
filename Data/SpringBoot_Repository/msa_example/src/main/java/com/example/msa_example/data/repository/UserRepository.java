package com.example.msa_example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.msa_example.data.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
    
}
