package com.isaagerald.blog_post.dao;

import com.isaagerald.blog_post.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostDao extends JpaRepository<BlogPost, Integer> {


    List<BlogPost> findByTitleContainingOrContentContainingOrCategoryContaining(String title, String content, String category);
}
