package com.example.petproject.services;

import com.example.petproject.dtos.users.UserDto;
import com.example.petproject.models.entities.User;

public interface UserService {
    public void addUser(UserDto user);
}
