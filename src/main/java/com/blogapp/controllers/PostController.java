package com.blogapp.controllers;

import com.blogapp.payloads.PostDto;
import com.blogapp.payloads.PostResponse;
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
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto,
                                              @PathVariable int userId,
                                              @PathVariable int categoryId)
    {
        return new ResponseEntity<>(postService.createPost(postDto, userId, categoryId), HttpStatus.CREATED);
    }
    @GetMapping("all")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                    @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize)
    {
        return new ResponseEntity<PostResponse>(postService.getAllPosts(pageNumber, pageSize), HttpStatus.FOUND);
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.FOUND);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<PostResponse> getPostsByUser(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                        @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
                                                        @PathVariable int userId) {
        return new ResponseEntity<PostResponse>(postService.getPostsByUser(userId, pageNumber, pageSize), HttpStatus.FOUND);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable int categoryId)
    {
        return new ResponseEntity<>(postService.getPostsByCategory(categoryId), HttpStatus.FOUND);
    }
    @PutMapping("{postId}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable int postId)
    {
        return new ResponseEntity<>(postService.updatePost(postDto, postId), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{postId}")
    public ResponseEntity<String> deletePost(@PathVariable int postId)
    {
        postService.deletePostById(postId);
        return new ResponseEntity<>("Post with Id '"+postId+"' deleted!", HttpStatus.OK);
    }
}
