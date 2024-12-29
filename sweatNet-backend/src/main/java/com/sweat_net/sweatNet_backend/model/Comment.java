package com.sweat_net.sweatNet_backend.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    private String id;
    private String authorId;
    private String content;
    private String postId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
