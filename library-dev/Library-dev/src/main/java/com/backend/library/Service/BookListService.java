package com.backend.library.Service;

import com.backend.library.dto.BookResponse;
import com.backend.library.dto.CategoryType;
import com.backend.library.entity.Category;
import com.backend.library.repository.BookRepository;
import com.backend.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookListService {
    private final CategoryService categoryService;
    private BookRepository bookRepository;

    //CONVET REQUEST PARAM
    public List<BookResponse> bookList(BookSearchRequest bookSearchRequest) {
        return bookRepository.findAll(PageRequest.of(bookSearchRequest.getPage(), bookSearchRequest.getSize()))
                .getContent()
                .stream()
                .map(model ->

                        BookResponse.builder()
                                .bookStatus(model.getBookStatus())
                                .authorName(model.getAuthorName())
                                .title(model.getTitle())
                                .imageUrl(model.getImage().getImageUrl())
                                .build())
                .collect(Collectors.toList());
    }

    public List<BookResponse> searhByCategory(CategoryType categoryType) {
        final Category category=categoryService.findByName(categoryType.getValue());
        category.getBooks()
                .stream()

    }
}
//1.23.00 da kaldım
//https://www.youtube.com/watch?v=rA1XQRXPF2w
