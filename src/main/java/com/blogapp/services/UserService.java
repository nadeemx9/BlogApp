package com.blogapp.services;

import com.blogapp.dto.UserDto;
import com.blogapp.entities.User;
import com.blogapp.repositories.UserRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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
