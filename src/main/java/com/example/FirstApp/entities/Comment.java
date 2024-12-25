package com.example.FirstApp.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Timestamp created;
    private String body;
    private String attribute; // Optional: You can rename it to something meaningful.

    // One-to-Many relationship with Like
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes;
    // Many-to-One relationship with User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    private Post post;
}
