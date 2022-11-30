package com.backend.library.Service;

import com.backend.library.dto.BookResponse;
import com.backend.library.repository.BookRepository;
import com.backend.library.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListService {
    private CategoryRepository categoryRepository;
    private BookRepository bookRepository;

    public List<BookResponse> bookList(){
        bookRepository.findAll(PageRequest.of)
    }
}
//1.06.00 da kaldım
https://www.youtube.com/watch?v=rA1XQRXPF2w
