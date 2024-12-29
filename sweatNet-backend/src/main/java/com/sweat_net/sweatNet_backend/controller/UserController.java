package com.sweat_net.sweatNet_backend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweat_net.sweatNet_backend.dto.UserDTO;
import com.sweat_net.sweatNet_backend.service.UserServise;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserServise userServise;

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO userRequest) {
        return userServise.register(userRequest);
    }

    @GetMapping("/{id}/profile")
    public UserDTO getUserById(@PathVariable String id) {
        return userServise.getUserById(id);
    }

    @PutMapping("/{id}/profile")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO userRequest) {
        return userServise.updateUser(id, userRequest);
    }

    @DeleteMapping("{id}/profile")
    public UserDTO deleteUser(@PathVariable String id) {
        return userServise.deleteUser(id);
    }

}
