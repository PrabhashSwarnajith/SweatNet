package com.sweat_net.sweatNet_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sweat_net.sweatNet_backend.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
