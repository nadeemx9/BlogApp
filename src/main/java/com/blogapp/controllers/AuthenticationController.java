package com.blogapp.controllers;

import com.blogapp.config.jwt.JwtService;
import com.blogapp.payloads.AuthenticationRequest;
import com.blogapp.payloads.AuthenticationResponse;
import com.blogapp.payloads.UserDto;
import com.blogapp.services.AuthenticaionService;
import com.blogapp.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticaionService authenticaionService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid UserDto userDto)
    {
        return ResponseEntity.ok(authenticaionService.register(userDto));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest request)
    {
        return ResponseEntity.ok(authenticaionService.authenticate(request));
    }
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello!";
    }
}
