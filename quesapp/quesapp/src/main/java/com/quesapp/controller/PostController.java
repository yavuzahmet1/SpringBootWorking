package com.quesapp.controller;

import com.quesapp.dto.request.PostCreateRequest;
import com.quesapp.dto.request.PostUpdateRequest;
import com.quesapp.entities.Post;
import com.quesapp.service.abstracts.PostService;
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
    public Post getOnePostById(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){

        return postService.createOnePost(newPostRequest);
    }
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId,@RequestBody PostUpdateRequest updatePost){
        return  postService.updateOnePostById(postId,updatePost);
    }
    @DeleteMapping
    public void deleteOnePost(Long postId){
        postService.deletePostById(postId);
    }
}
