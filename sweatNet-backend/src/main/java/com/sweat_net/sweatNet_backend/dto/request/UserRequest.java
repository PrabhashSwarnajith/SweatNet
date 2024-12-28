package com.sweat_net.sweatNet_backend.dto.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String email;
    private String passward;
    private String bio;
    private String image;
    private LocalDate createdAt;
}
