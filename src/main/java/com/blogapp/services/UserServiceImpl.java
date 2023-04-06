package com.blogapp.services;

import com.blogapp.dto.UserDto;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.existsById(user.getUserId()))
            return userRepository.save(user);
        else
            throw new ResourceNotFoundException("User with ID '" +user.getUserId()+"' does not exist!");
    }

    @Override
    public User getUserById(Integer id) {
        if(userRepository.existsById(id))
            return userRepository.findById(id).get();
        else
            throw new ResourceNotFoundException("User with ID '" +id+"' does not exist!");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUserById(Integer id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with ID '" + id + "' deleted ";
        }
        else
            throw new ResourceNotFoundException("User with ID '" +id+"' does not exist!");
    }

    public User dtoToUser(UserDto userDto)
    {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto(User user)
    {
        return new UserDto(user.getUserId(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}
