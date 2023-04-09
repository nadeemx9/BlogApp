package com.blogapp.services;

import com.blogapp.payloads.PostDto;
import com.blogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto, int id);
    PostDto getPostById(int id);
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection);
    PostResponse getPostsByUser(Integer userId, Integer pageNumber, Integer pageSize);
    PostResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
    void deletePostById(int id);
}
