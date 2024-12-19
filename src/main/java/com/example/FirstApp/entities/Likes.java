package com.example.FirstApp.entities;

import jakarta.persistence.*;

@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    private Integer likes;



    // Many-to-One relationship with Comment
    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "commentId")
    private Comment comment;
    // Many-to-One relationship with Post

}
