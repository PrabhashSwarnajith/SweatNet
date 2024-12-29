package com.sweat_net.sweatNet_backend.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sweat_net.sweatNet_backend.dto.UserDTO;
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
    public UserDTO register(UserDTO userRequest) {

        if (userRequest.getUsername().isEmpty() || userRequest.getEmail().isEmpty()
                || userRequest.getPassword().isEmpty()) {
            log.warn("Invalid input data {username: {}, email: {}}", userRequest.getUsername(), userRequest.getEmail());
            return UserDTO.builder()
                    .userId(null)
                    .message("Username, email, or password cannot be empty")
                    .build();
        }

        if (userRepository.existsByUsername(userRequest.getUsername()) ||
                userRepository.existsByEmail(userRequest.getEmail())) {
            log.info("User already exists {username: {}, email: {}}", userRequest.getUsername(),
                    userRequest.getEmail());

            return UserDTO.builder()
                    .message("User already exists")
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

        return UserDTO.builder()
                .userId(user.getId())
                .message("User created successfully")
                .build();

    }

    @Override
    public UserDTO getUserById(String id) {

        return userRepository.findById(id)
                .map(user -> UserDTO.builder()
                        .userId(user.getId())
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
    public UserDTO updateUser(String id, UserDTO userRequest) {

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            log.warn("User not found for id: {}", id);
            return UserDTO.builder()
                    .userId(null)
                    .message("User not found")
                    .build();
        }

        User user = userOptional.get();

        if (userRequest.getUsername() != null && !userRequest.getUsername().isEmpty()) {
            log.info("Username updated successfully for id: {}", id);
            user.setUsername(userRequest.getUsername());
        }

        if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
            log.info("Email updated successfully for id: {}", id);
            user.setEmail(userRequest.getEmail());
        }

        if (userRequest.getPassword() != null && !userRequest.getPassword().isEmpty()) {
            log.info("Password updated successfully for id: {}", id);
            user.setPassword(userRequest.getPassword());
        }

        if (userRequest.getBio() != null && !userRequest.getBio().isEmpty()) {
            log.info("Bio updated successfully for id: {}", id);
            user.setBio(userRequest.getBio());
        }

        if (userRequest.getImage() != null && !userRequest.getImage().isEmpty()) {
            log.info("Image updated successfully for id: {}", id);
            user.setImage(userRequest.getImage());
        }

        userRepository.save(user);
        log.info("User updated successfully and saved to the database for id: {}", id);

        return UserDTO.builder()
                .userId(user.getId())
                .message("User updated successfully")
                .build();
    }

    @Override
    public UserDTO deleteUser(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            log.warn("User not found for id: {}", id);
            return UserDTO.builder()
                    .userId(null)
                    .message("User not found")
                    .build();
        }
        userRepository.deleteById(id);
        log.info("User deleted successfully for id: {}", id);
        return UserDTO.builder()
                .userId(id)
                .message("User deleted successfully")
                .build();
    }

}
