package com.quesapp.controller;

import com.quesapp.dto.request.PostCreateRequest;
import com.quesapp.entities.Post;
import com.quesapp.entities.User;
import com.quesapp.service.abstracts.PostService;
import com.quesapp.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){//@RequestParam bize gelen requesti bize parse et ve sağımda gelen değişkenin içine at demektir.
        return postService.getAllPosts(userId);
    }
    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostId(postId);
    }
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){

        return postService.createOnePost(newPostRequest);
    }
}
