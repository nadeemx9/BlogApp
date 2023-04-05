package com.blogapp.controllers;

import com.blogapp.entities.User;
import com.blogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/post")
    public String add()
    {
        save();
        return "Added!";
    }

    public void save()
    {
        userRepository.save(new User(null, "Nadeem"));
    }

}
