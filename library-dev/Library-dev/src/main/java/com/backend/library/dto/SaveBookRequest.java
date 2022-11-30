package com.backend.library.dto;

import com.backend.library.entity.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;

@Data
public final class SaveBookRequest {//kalıtıma uygun olmadığından final yaptık
    @NotBlank(message = "Title not empty")
    private String title;
    @NotBlank(message = "Author not empty")
    private String authorName;
    @NotNull
    private BookStatus bookStatus;
    @NotBlank
    private String publisher;
    @NotNull
    private Integer lastPageNumber;
    @NotNull
    private Integer totalPage;
    private File image; //frontend ile konuştuğumuzda bana bir file göndereceği söylenecek
    @NotNull
    private Long categoryId;

}
