package com.blogapp.services;

import com.blogapp.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer id);
    UserDto getUserById(Integer id);
    List<UserDto> getAllUsers();
    String deleteUserById(Integer id);

}
