package com.codegym.service.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import com.codegym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> showAllComment() {
        return commentRepository.showAllComment();
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    @Override
    public void addLike(Comment comment) {
        commentRepository.addLike(comment);
    }

    @Override
    public void disLike(Comment comment) {
        commentRepository.disLike(comment);
    }

    @Override
    public Comment findOne(Long id) {
        return commentRepository.findOne(id);
    }
}
