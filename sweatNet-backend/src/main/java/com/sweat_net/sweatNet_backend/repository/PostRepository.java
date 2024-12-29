package com.sweat_net.sweatNet_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sweat_net.sweatNet_backend.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
