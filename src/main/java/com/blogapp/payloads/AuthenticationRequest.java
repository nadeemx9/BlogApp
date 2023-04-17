package com.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotEmpty(message = "Username should not be Empty!")
    @NotBlank(message = "Username should not be empty!")
    @Size(min = 3, message = "Username must be atleast 3 characters!")
    private String username;
    @NotEmpty(message = "Password should not be Empty!")
    @NotBlank(message = "Password should not be empty!")
    @Size(min = 3, message = "Password must be atleast 3 characters!")
    private String password;
}
