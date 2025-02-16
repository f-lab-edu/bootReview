package com.example.moduleapp.controller;


import com.example.modulecore.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final List<UserDto> users = new ArrayList<>();

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        userDto.setId((long) (users.size() + 1));  // ID 자동 증가
        users.add(userDto);
        return userDto;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return users;
    }
}