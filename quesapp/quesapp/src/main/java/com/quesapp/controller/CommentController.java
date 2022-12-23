package com.quesapp.controller;

import com.quesapp.dto.request.CommentCreateRequest;
import com.quesapp.dto.request.CommentUpdateRequest;
import com.quesapp.entities.Comment;
import com.quesapp.service.abstracts.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentService.getAllCommentsWithParam(userId, postId);
        }
        return null;
    }

    @GetMapping("{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneCommentId(commentId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest commentRequest) {
        return commentService.createOneComment(commentRequest);
    }

    @PutMapping("/commentId")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateOneCommentById(commentId,commentUpdateRequest);
    }
    @DeleteMapping
    public void  deleteOneComment(@PathVariable Long commentId){
        commentService.deleteOneCommentById(commentId);
    }
}
