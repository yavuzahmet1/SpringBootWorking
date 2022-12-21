package com.quesapp.service.abstracts;

import com.quesapp.dto.request.PostCreateRequest;
import com.quesapp.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts(Optional<Long> userId);

    Post getOnePostId(Long postId);

    Post createOnePost(PostCreateRequest newPostRequest);
}
