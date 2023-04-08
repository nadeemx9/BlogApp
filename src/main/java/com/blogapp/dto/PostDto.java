package com.blogapp.dto;

import com.blogapp.entities.Category;
import com.blogapp.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Integer postId;
    @NotEmpty(message = "Post title should not be Empty!")
    @NotBlank(message = "Post title should not be Empty!")
    @Size(min = 3, message = "Post Title must be atleast 3 characters!")
    private String postTitle;
    @NotEmpty(message = "Post Content should not be Empty!")
    @NotBlank(message = "Post Content should not be Empty!")
    @Size(min = 3, message = "Post Content must be atleast 3 characters!")
    private String postContent;
    private String postImage;
    private Date createdAt;
    private UserDto user;
    private CategoryDto category;

}
