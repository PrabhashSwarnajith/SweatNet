package com.sweat_net.sweatNet_backend.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String userId;
    private String message;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String image;
    private LocalDate createdAt;
    private List<String> followers;
    private List<String> following;
}
