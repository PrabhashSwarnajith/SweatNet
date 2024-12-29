package com.sweat_net.sweatNet_backend.service;

import com.sweat_net.sweatNet_backend.dto.UserDTO;

public interface UserServise {

    UserDTO register(UserDTO userRequest);

    UserDTO getUserById(String id);

    UserDTO updateUser(String id, UserDTO userRequest);

    UserDTO deleteUser(String id);

}
