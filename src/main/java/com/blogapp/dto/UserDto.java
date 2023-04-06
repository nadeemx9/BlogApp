package com.blogapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
    private Integer userId;
    private String name;
    private String username;
    private String email;
    private String password;

}
