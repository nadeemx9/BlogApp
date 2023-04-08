package com.blogapp.controllers;

import com.blogapp.dto.PostDto;
import com.blogapp.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto, @PathVariable int userId, @PathVariable int categoryId)
    {
        return new ResponseEntity<>(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
    }
    @GetMapping
    public List<PostDto> getAllPosts()
    {
        return postService.getAllPosts();
    }
}
