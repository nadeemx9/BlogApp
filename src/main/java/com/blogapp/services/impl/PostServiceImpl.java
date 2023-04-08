package com.blogapp.services.impl;

import com.blogapp.dto.CategoryDto;
import com.blogapp.dto.PostDto;
import com.blogapp.dto.UserDto;
import com.blogapp.entities.Category;
import com.blogapp.entities.Post;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repositories.CategoryRepository;
import com.blogapp.repositories.PostRepository;
import com.blogapp.repositories.UserRepository;
import com.blogapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User with ID '"+userId+"' not found!"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category with ID '"+categoryId+"' not found!"));

        postDto.setPostImage("default.png");
        postDto.setUser(modelMapper.map(user, UserDto.class));
        postDto.setCategory(modelMapper.map(category, CategoryDto.class));
        postDto.setCreatedAt(new Date());

        Post savedPost = postRepository.save(dtoToPost(postDto));
        return postToDto(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, int id) {
        return null;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postsToDtos(postRepository.findAll());
    }

    @Override
    public List<PostDto> getPostByUser(int userId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByCategory(int categoryId) {
        return null;
    }

    @Override
    public void deletePostById(int id) {

    }

    public Post dtoToPost(PostDto postDto)
    {
        return modelMapper.map(postDto, Post.class);
    }

    public PostDto postToDto(Post post)
    {
        return modelMapper.map(post, PostDto.class);
    }

    public List<PostDto> postsToDtos(List<Post> posts)
    {
        return modelMapper.map(posts, new TypeToken<List<PostDto>>() {}.getType());
    }
}
