package com.sweat_net.sweatNet_backend.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sweat_net.sweatNet_backend.dto.request.UserRequest;
import com.sweat_net.sweatNet_backend.dto.response.UserMResponse;
import com.sweat_net.sweatNet_backend.dto.response.UserResponse;
import com.sweat_net.sweatNet_backend.model.User;
import com.sweat_net.sweatNet_backend.repository.UserRepository;
import com.sweat_net.sweatNet_backend.service.UserServise;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserServise {

    private final UserRepository userRepository;

    @Override
    public UserMResponse register(UserRequest userRequest) {

        if (userRequest.getUsername().isEmpty() || userRequest.getEmail().isEmpty()
                || userRequest.getPassword().isEmpty()) {
            log.warn("Invalid input data {username: {}, email: {}}", userRequest.getUsername(), userRequest.getEmail());
            return UserMResponse.builder()
                    .UserId(null)
                    .massage("Username, email, or password cannot be empty")
                    .build();
        }

        if (userRepository.existsByUsername(userRequest.getUsername()) ||
                userRepository.existsByEmail(userRequest.getEmail())) {
            log.info("User already exists {username: {}, email: {}}", userRequest.getUsername(),
                    userRequest.getEmail());

            return UserMResponse.builder()
                    .massage("User already exists")
                    .build();
        }

        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .createdAt(LocalDate.now())
                .build();

        userRepository.save(user);
        log.info("User created successfully {id: {}}", user.getId());

        return UserMResponse.builder()
                .UserId(user.getId())
                .massage("User created successfully")
                .build();

    }

    @Override
    public UserResponse getUserById(String id) {

        return userRepository.findById(id)
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .bio(user.getBio())
                        .image(user.getImage())
                        .createdAt(user.getCreatedAt())
                        .followers(user.getFollowers())
                        .following(user.getFollowing())
                        .build())
                .orElseThrow(() -> {
                    log.warn("User not found for id: {}", id);
                    return new IllegalArgumentException("User not found for id: " + id);
                });

    }

    @Override
    public UserMResponse updateUser(String id, UserRequest userRequest) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            log.warn("User not found for id: {}", id);
            return UserMResponse.builder()
                    .UserId(null)
                    .massage("User not found")
                    .build();
        }

        User user = userOptional.get();

        if (!userRequest.getUsername().isEmpty()) {
            user.setUsername(userRequest.getUsername());
        }

        if (!userRequest.getEmail().isEmpty()) {
            user.setEmail(userRequest.getEmail());
        }

        if (!userRequest.getPassword().isEmpty()) {
            user.setPassword(userRequest.getPassword());
        }

        if (!userRequest.getBio().isEmpty()) {
            user.setBio(userRequest.getBio());
        }

        if (!userRequest.getImage().isEmpty()) {
            user.setImage(userRequest.getImage());
        }

        userRepository.save(user);
        log.info("User updated successfully {id: {}}", user.getId());

        return UserMResponse.builder()
                .UserId(user.getId())
                .massage("User updated successfully")
                .build();
    }

    @Override
    public UserMResponse deleteUser(String id) {

    }

}
