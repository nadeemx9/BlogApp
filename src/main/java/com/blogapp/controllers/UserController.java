package com.blogapp.controllers;

import com.blogapp.dto.UserDto;
import com.blogapp.entities.User;
import com.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<UserDto>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<UserDto>(userService.getUserById(userId), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<UserDto>(userService.createUser(userDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId)
    {
        return new ResponseEntity<String>(userService.deleteUserById(userId), HttpStatus.OK);
    }
}
