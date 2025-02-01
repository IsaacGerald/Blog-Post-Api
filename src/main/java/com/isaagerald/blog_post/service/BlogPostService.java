package com.isaagerald.blog_post.service;

import com.isaagerald.blog_post.dao.BlogPostDao;
import com.isaagerald.blog_post.exception.ApiRequestException;
import com.isaagerald.blog_post.model.BlogPost;
import com.isaagerald.blog_post.model.BlogPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    
    @Autowired
    BlogPostDao blogPostDao;

    public ResponseEntity<BlogPost> createPost(BlogPostDto blogPostDto) {


        if (blogPostDto.getTitle().isBlank())
            throw new ApiRequestException("Missing title");

        if (blogPostDto.getContent().isBlank())
            throw new ApiRequestException("Missing content");

        if (blogPostDto.getCategory().isBlank())
            throw new ApiRequestException("Missing Category");


        BlogPost blogPostFromDb = blogPostDao.save(blogPostDto.toEntity());


        return new ResponseEntity<>(blogPostFromDb, HttpStatus.CREATED);
    }


    public ResponseEntity<BlogPost> updatePost(Integer id, BlogPostDto blogPostDto) {

        if (id == null)
            throw new ApiRequestException("Missing id");

        if (blogPostDto.getTitle().isBlank())
            throw new ApiRequestException("Missing Title");

        if (blogPostDto.getContent().isBlank())
            throw new ApiRequestException("Missing content");

        if (blogPostDto.getCategory().isBlank())
            throw new ApiRequestException("Missing category");

        Optional<BlogPost> blogPostFromDb = blogPostDao.findById(id);

        if (blogPostFromDb.isEmpty())
            throw new ApiRequestException("Post Not Found");

        BlogPost blogPost = blogPostDto.toEntity();
        blogPost.setId(id);
        blogPost.setCreatedAt(blogPostFromDb.get().getCreatedAt());

        BlogPost updateBlogPost = blogPostDao.save(blogPost);

        return new ResponseEntity<>(updateBlogPost, HttpStatus.CREATED);

    }


    public ResponseEntity<String> deletePost(Integer id) {

        Optional<BlogPost> blogPostFromDb = blogPostDao.findById(id);

        if (blogPostFromDb.isEmpty())
            throw  new ApiRequestException("Post Not Found");


        blogPostDao.deleteById(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


    public ResponseEntity<BlogPost> getPost(Integer id) {

        Optional<BlogPost> blogPost = blogPostDao.findById(id);

        return blogPost.map(post -> new ResponseEntity<>(post, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }


    public ResponseEntity<List<BlogPost>> getPosts(String term) {

        List<BlogPost> blogPosts;

        if (term == null || term.isBlank()) {
            blogPosts = blogPostDao.findAll();
        } else {
            blogPosts = blogPostDao.findByTitleContainingOrContentContainingOrCategoryContaining(term, term, term);
        }


        return new ResponseEntity<>(blogPosts, HttpStatus.OK);

    }

}
