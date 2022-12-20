package com.quesapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    private long id;
    private long userId;
    private long title;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
