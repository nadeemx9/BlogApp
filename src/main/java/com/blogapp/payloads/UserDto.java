package com.blogapp.payloads;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
    private Integer userId;
    @NotEmpty(message = "Name should not be Empty!")
    @NotBlank(message = "Name should not be empty!")
    @Size(min = 3, message = "Name must be atleast 3 characters!")
    private String name;
    @NotEmpty(message = "Username should not be Empty!")
    @NotBlank(message = "Username should not be empty!")
    @Size(min = 3, message = "Username must be atleast 3 characters!")
    private String username;
    @NotEmpty(message = "Email should not be Empty!")
    @Email(message = "Enter valid Email!")
    private String email;
    @NotEmpty(message = "Password should not be Empty!")
    @NotBlank(message = "Password should not be empty!")
    @Size(min = 3, message = "Password must be atleast 3 characters!")
    private String password;

}
