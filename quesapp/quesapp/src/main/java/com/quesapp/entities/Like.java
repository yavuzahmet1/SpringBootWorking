package com.quesapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "p_likes")
@Data
public class Like {
    @Id
    private long id;
    private long postId;
    private long userId;
}
