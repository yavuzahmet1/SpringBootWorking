package com.backend.library.dto;

import com.backend.library.entity.BookStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.File;

@Data
@SuperBuilder
@NoArgsConstructor
public class BookResponse {
    private String title;
    private String authorName;
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    private File image;
    private Long categoryId;
    private String imageUrl;
}
