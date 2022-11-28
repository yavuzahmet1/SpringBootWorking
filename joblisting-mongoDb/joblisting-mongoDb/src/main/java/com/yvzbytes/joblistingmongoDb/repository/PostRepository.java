package com.yvzbytes.joblistingmongoDb.repository;

import com.yvzbytes.joblistingmongoDb.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
