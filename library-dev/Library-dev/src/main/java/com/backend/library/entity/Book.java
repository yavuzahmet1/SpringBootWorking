package com.backend.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "books")
@SuperBuilder
public class Book extends BaseEntity {
    private String title;
    private String authorName;

    @Enumerated(value = EnumType.STRING)
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;

    @OneToOne
    private Image image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long userId;
}
