package com.quesapp.service.abstracts;

import com.quesapp.dto.request.PostCreateRequest;
import com.quesapp.dto.request.PostUpdateRequest;
import com.quesapp.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts(Optional<Long> userId);

    Post getOnePostById(Long postId);

    Post createOnePost(PostCreateRequest newPostRequest);

    Post updateOnePostById(Long postId, PostUpdateRequest updatePost);

    void deletePostById(Long postId);
}
