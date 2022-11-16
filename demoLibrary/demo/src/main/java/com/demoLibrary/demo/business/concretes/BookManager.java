package com.demoLibrary.demo.business.concretes;

import com.demoLibrary.demo.business.abstracts.BookService;
import com.demoLibrary.demo.dataAccess.BookRepository;
import com.demoLibrary.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookManager implements BookService {
    private final BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        return null;
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book, Long id) {
        Optional<Book> inDbBook = bookRepository.findById(id);

        if (inDbBook.isPresent()) {
            Book book1 = inDbBook.get();
            book1.setName(book.getName());
            book1.setPageCount(book.getPageCount());
            bookRepository.save(book1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
