package com.sweat_net.sweatNet_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweat_net.sweatNet_backend.dto.PostDTO;
import com.sweat_net.sweatNet_backend.service.PostService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public PostDTO createPost() {
        return null;
    }
}
