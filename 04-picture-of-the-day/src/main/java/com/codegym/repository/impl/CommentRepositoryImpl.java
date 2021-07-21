package com.codegym.repository.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Comment> showAllComment() {
        String hql = "select c from Comment c where c.date = CURRENT_DATE";
        TypedQuery<Comment> query = manager.createQuery(hql, Comment.class);
        return query.getResultList();
    }

    @Override
    public void addComment(Comment comment) {
        String sql = "call insert_comment(:author,:feedback,:rating)";
        Query query = manager.createNativeQuery(sql);
        query.setParameter("author", comment.getAuthor());
        query.setParameter("feedback", comment.getFeedback());
        query.setParameter("rating", "+ " + comment.getRating());
        query.executeUpdate();
    }

    @Override
    public void addLike(Comment comment) {
        comment.setLikes(comment.getLikes() + 1);
        String queryStr = "Update Comment set likes = :newLike where id= :id";
        Query query = manager.createQuery(queryStr);
        query.setParameter("newLike", comment.getLikes());
        query.setParameter("id", comment.getId());
        query.executeUpdate();
    }

    @Override
    public void disLike(Comment comment) {
        comment.setLikes(comment.getLikes() - 1);
        String queryStr = "Update Comment set likes = :newLike where id= :id";
        Query query = manager.createQuery(queryStr);
        query.setParameter("newLike", comment.getLikes());
        query.setParameter("id", comment.getId());
        query.executeUpdate();
    }

    @Override
    public Comment findOne(Long id) {
        String hql = "select c from Comment c where c.id = :id";
        TypedQuery<Comment> query = manager.createQuery(hql, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
