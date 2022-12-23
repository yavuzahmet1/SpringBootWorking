package com.quesapp.service.concretes;

import com.quesapp.dto.request.CommentCreateRequest;
import com.quesapp.dto.request.CommentUpdateRequest;
import com.quesapp.entities.Comment;
import com.quesapp.entities.Post;
import com.quesapp.entities.User;
import com.quesapp.repository.CommentRepository;
import com.quesapp.service.abstracts.CommentService;
import com.quesapp.service.abstracts.PostService;
import com.quesapp.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentManager implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;


    @Override
    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else
            return commentRepository.findAll();
    }

    @Override
    public Comment getOneCommentId(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public Comment createOneComment(CommentCreateRequest commentRequest) {
        User user = userService.getOneUserById(commentRequest.getUserId());
        Post post = postService.getOnePostById(commentRequest.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(commentRequest.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(commentRequest.getText());
            return commentRepository.save(commentToSave);
        } else
            return null;
    }

    @Override
    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(commentToUpdate);
        } else
            return null;
    }

    @Override
    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
