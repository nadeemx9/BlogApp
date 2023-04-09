package com.blogapp.services;

import com.blogapp.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto, int id);
    PostDto getPostById(int id);
    List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);
    List<PostDto> getPostsByUser(int userId);
    List<PostDto> getPostsByCategory(Integer categoryId);
    void deletePostById(int id);
}
