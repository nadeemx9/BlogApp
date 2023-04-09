package com.blogapp.services;

import com.blogapp.payloads.PostDto;
import com.blogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto, int id);
    PostDto getPostById(int id);
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);
    List<PostDto> getPostsByUser(int userId);
    List<PostDto> getPostsByCategory(Integer categoryId);
    void deletePostById(int id);
}
