package com.sweat_net.sweatNet_backend.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String id;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String image;
    private LocalDate createdAt;
    private List<String> followers;
    private List<String> following;
}
