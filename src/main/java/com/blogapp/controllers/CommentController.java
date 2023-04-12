package com.blogapp.controllers;

import com.blogapp.payloads.CommentDto;
import com.blogapp.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody @Valid CommentDto commentDto,
                                                    @PathVariable Integer postId)
    {
        return new ResponseEntity<>(commentService.createComment(commentDto, postId), HttpStatus.CREATED);
    }
    @DeleteMapping("{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Integer commentId)
    {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().body("Comment with ID '"+commentId+"' deleted! ");
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable Integer postId)
    {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.FOUND);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CommentDto>> getCommentsByUserId(@PathVariable Integer userId)
    {
        return new ResponseEntity<>(commentService.getCommentsByUserId(userId), HttpStatus.FOUND);
    }
}
