package com.isaagerald.blog_post.controller;

import com.isaagerald.blog_post.model.BlogPost;
import com.isaagerald.blog_post.model.BlogPostDto;
import com.isaagerald.blog_post.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;


    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPostDto blogPostDto){
        return blogPostService.createPost(blogPostDto);
    }


    @PutMapping("{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Integer id, @RequestBody BlogPostDto blogPostDto){
        return blogPostService.updatePost(id, blogPostDto);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable Integer id){
        return blogPostService.deletePost(id);
    }


    @GetMapping("{id}")
    public ResponseEntity<BlogPost> getPost(@PathVariable Integer id){
        return blogPostService.getPost(id);
    }


    @GetMapping
    public ResponseEntity<List<BlogPost>> getPosts(@RequestParam(required = false) String term){
        return blogPostService.getPosts(term);
    }



}
