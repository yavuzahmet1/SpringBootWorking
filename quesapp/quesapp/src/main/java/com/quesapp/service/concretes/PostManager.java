package com.quesapp.service.concretes;

import com.quesapp.dto.request.PostCreateRequest;
import com.quesapp.entities.Post;
import com.quesapp.entities.User;
import com.quesapp.repository.PostRepository;
import com.quesapp.service.abstracts.PostService;
import com.quesapp.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostManager implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;


    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
       if (userId.isPresent()){
           return postRepository.findByUserId(userId.get());
       }
        return postRepository.findAll();
    }

    @Override
    public Post getOnePostId(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user=userService.getByUser(newPostRequest.getUserId());
        if (user==null)
            return null;
        Post toSave=new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }
}
