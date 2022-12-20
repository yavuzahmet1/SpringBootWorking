package com.quesapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
public class Comment {
    @Id
    private long id;
    private long postId;
    private long userId;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
