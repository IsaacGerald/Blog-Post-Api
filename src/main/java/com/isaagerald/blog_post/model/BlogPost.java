package com.isaagerald.blog_post.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private String category;

    private List<String> tags;

    private String createdAt;

    private String updatedAt;

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now().toString();
        this.updatedAt = Instant.now().toString();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = Instant.now().toString();
    }


}
