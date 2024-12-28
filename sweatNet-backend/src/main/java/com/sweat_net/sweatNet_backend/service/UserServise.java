package com.sweat_net.sweatNet_backend.service;

import com.sweat_net.sweatNet_backend.dto.request.UserRequest;
import com.sweat_net.sweatNet_backend.dto.response.UserMResponse;
import com.sweat_net.sweatNet_backend.dto.response.UserResponse;

public interface UserServise {

    UserMResponse register(UserRequest userRequest);

    UserResponse getUserById(String id);

    UserMResponse updateUser(String id, UserRequest userRequest);

    UserMResponse deleteUser(String id);

}
