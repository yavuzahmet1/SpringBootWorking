package com.backend.library.Service;

import com.backend.library.dto.BookListItemResponse;
import com.backend.library.dto.SaveBookRequest;
import com.backend.library.entity.Book;
import com.backend.library.entity.Category;
import com.backend.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BookSaveService {
    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Transactional
    public void saveBook(SaveBookRequest saveBookRequest) {
        Category category = categoryService.loadCategory(saveBookRequest.getCategoryId());
        final Book book = Book.builder()
                .category(category)
                .bookStatus(saveBookRequest.getBookStatus())
                .title(saveBookRequest.getTitle())
                .lastPageNumber(saveBookRequest.getLastPageNumber())
                .authorName(saveBookRequest.getAuthorName())
                .totalPage(saveBookRequest.getTotalPage())
                .build();

        final Book fromDB=bookRepository.save(book);
        BookListItemResponse.builder()
                .categoryName(book.getCategory().getName())
                .id(fromDB.getId())
                .bookStatus(fromDB.getBookStatus())
                .publisher(fromDB.getPublisher())
                .authorName(fromDB.getAuthorName())
                .totalPage(fromDB.getTotalPage())
                .lastPageNumber(fromDB.getLastPageNumber())
                .build();

    }


}
