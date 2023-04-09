package com.blogapp.services.impl;

import com.blogapp.payloads.UserDto;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repositories.UserRepository;
import com.blogapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userToDto(userRepository.save(dtoToUser(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        if(userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            user.setName(userDto.getName());
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            return userToDto(userRepository.save(user));
        }
        else
            throw new ResourceNotFoundException("User with ID '" +id+"' does not exist!");
    }

    @Override
    public UserDto getUserById(Integer id) {
        if(userRepository.existsById(id))
            return userToDto(userRepository.findById(id).get());
        else
            throw new ResourceNotFoundException("User with ID '" +id+"' does not exist!");
    }

    @Override
    public List<UserDto> getAllUsers() {
        return usersToDtos(userRepository.findAll());
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
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user)
    {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public List<UserDto> usersToDtos(List<User> users)
    {
        List<UserDto> dtos = modelMapper.map(users, new TypeToken<List<UserDto>>() {}.getType());
        return dtos;
    }
}
