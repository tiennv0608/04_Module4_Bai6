package com.codegym.repository;

import com.codegym.model.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> showAllComment();

    void addComment(Comment comment);

    void addLike(Comment comment);

    void disLike(Comment comment);

    Comment findOne(Long id);
}
