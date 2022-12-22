package com.quesapp.service.abstracts;

import com.quesapp.dto.request.CommentCreateRequest;
import com.quesapp.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

    Comment getOneCommentId(Long commentId);

    Comment createOneComment(CommentCreateRequest commentRequest);
}
