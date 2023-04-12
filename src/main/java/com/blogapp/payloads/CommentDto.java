package com.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Integer commentId;
    @NotEmpty(message = "Comment should not be Empty!")
    @NotBlank(message = "Comment should not be Empty!")
    private String content;
}
