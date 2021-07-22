package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService extends GeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllOrOrderByDate(Pageable pageable);
}
