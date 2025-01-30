package com.isaagerald.blog_post.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPostDto {

    private String title;

    private String content;

    private String category;

    private List<String> tags;


    public BlogPost toEntity(){
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(this.title);
        blogPost.setContent(this.content);
        blogPost.setCategory(this.category);
        blogPost.setTags(this.tags);

        return blogPost;
    }
}

