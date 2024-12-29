package com.sweat_net.sweatNet_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {

    private String message;
    private String postId;
    private String authorId;
    private String content;
    private String image;
    private String createdAt;
    private String updatedAt;
    private int likes;
    private int comments;
}
