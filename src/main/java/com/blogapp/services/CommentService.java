package com.blogapp.services;

import com.blogapp.payloads.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto comment, int postId);
    void deleteComment(int id);
    List<CommentDto> getCommentsByPostId(Integer id);
    List<CommentDto> getCommentsByUserId(Integer id);

}
