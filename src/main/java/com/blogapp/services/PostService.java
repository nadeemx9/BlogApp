package com.blogapp.services;

import com.blogapp.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId);
    PostDto updatePost(PostDto postDto, int id);
    List<PostDto> getAllPosts();
    List<PostDto> getPostByUser(int userId);
    List<PostDto> getPostsByCategory(int categoryId);
    void deletePostById(int id);
}
