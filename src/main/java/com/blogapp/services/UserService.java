package com.blogapp.services;

import com.blogapp.dto.UserDto;
import com.blogapp.entities.User;
import com.blogapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();
    String deleteUserById(Integer id);

}
