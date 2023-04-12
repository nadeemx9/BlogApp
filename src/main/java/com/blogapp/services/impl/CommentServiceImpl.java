package com.blogapp.services.impl;

import com.blogapp.entities.Comment;
import com.blogapp.entities.Post;
import com.blogapp.entities.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payloads.CommentDto;
import com.blogapp.payloads.PostDto;
import com.blogapp.repositories.CommentRepository;
import com.blogapp.repositories.PostRepository;
import com.blogapp.repositories.UserRepository;
import com.blogapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto, int postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post with ID '"+postId+"' not found!"));
        User user = userRepository.findById(post.getUser().getUserId()).get();

        Comment comment = new Comment();
        comment.setContent(commentDto.getContent());
        comment.setUser(user);
        comment.setPost(post);

        return commentToDto(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(int id) {
        commentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Comment with ID : '"+id+"' not found!"));
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Post with ID '"+id+"' not found "));

        List<CommentDto> comments = commentsToDtos(commentRepository.findByPost(post));

        return comments;
    }

    @Override
    public List<CommentDto> getCommentsByUserId(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User with ID '"+id+"' not found "));

        List<CommentDto> comments = commentsToDtos(commentRepository.findByUser(user));

        return comments;
    }

    public Comment dtoToComment(CommentDto commentDto)
    {
        return modelMapper.map(commentDto, Comment.class);
    }

    public CommentDto commentToDto(Comment comment)
    {
        return modelMapper.map(comment, CommentDto.class);
    }
    public List<CommentDto> commentsToDtos(List<Comment> comments)
    {
        return modelMapper.map(comments, new TypeToken<List<CommentDto>>() {}.getType());
    }
}
