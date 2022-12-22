package com.quesapp.service.concretes;

import com.quesapp.dto.request.CommentCreateRequest;
import com.quesapp.entities.Comment;
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
        return null;
    }
}
