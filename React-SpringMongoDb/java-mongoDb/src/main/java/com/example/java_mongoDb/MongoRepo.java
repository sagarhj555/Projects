package com.example.java_mongoDb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRepo extends MongoRepository<Post, Integer> {
    List<Post> findByProfileLike(String text);
}
