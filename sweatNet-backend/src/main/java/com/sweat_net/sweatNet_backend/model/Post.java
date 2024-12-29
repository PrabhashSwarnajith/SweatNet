package com.sweat_net.sweatNet_backend.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "posts")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    private String id;
    private String authorId;
    private String cotent;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> likes;
    private List<Comment> comments;
}
