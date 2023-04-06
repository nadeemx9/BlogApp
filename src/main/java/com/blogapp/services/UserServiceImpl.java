package com.blogapp.services;

import com.blogapp.dto.UserDto;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userToDto(userRepository.save(dtoToUser(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        if(userRepository.existsById(userDto.getUserId()))
            return userToDto(userRepository.save(dtoToUser(userDto)));
        else
            throw new ResourceNotFoundException("User with ID '" +userDto.getUserId()+"' does not exist!");
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
