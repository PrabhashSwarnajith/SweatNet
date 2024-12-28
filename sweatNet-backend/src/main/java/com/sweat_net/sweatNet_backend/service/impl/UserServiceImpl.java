package com.sweat_net.sweatNet_backend.service.impl;

import java.time.LocalDate;

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
                || userRequest.getPassward().isEmpty()) {
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
                .passward(userRequest.getPassward())
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public UserMResponse updateUser(String id, UserRequest userRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public UserMResponse deleteUser(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

}
