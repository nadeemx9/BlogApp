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
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId)
    {
        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user)
    {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId)
    {
        return new ResponseEntity<String>(userService.deleteUserById(userId), HttpStatus.OK);
    }
}
