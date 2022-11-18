package com.demoLibrary.demo.business.concretes;

import com.demoLibrary.demo.business.abstracts.AuthorService;
import com.demoLibrary.demo.core.utils.BookModel;
import com.demoLibrary.demo.dataAccess.AuthorRepository;
import com.demoLibrary.demo.dtos.author.request.AuthorRequest;
import com.demoLibrary.demo.dtos.author.response.AuthorListResponse;
import com.demoLibrary.demo.dtos.author.response.AuthorResponse;
import com.demoLibrary.demo.dtos.book.response.BookListResponse;
import com.demoLibrary.demo.entity.Author;
import com.demoLibrary.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorManager implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorManager(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorListResponse> getAll() {
        return authorRepository.findAll().stream().map(this::toAuthorListResponse).collect(Collectors.toList());
    }

    @Override
    public AuthorResponse getById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        /*if (author.isPresent()) {
            return author.get();
        }*///veya if bloğunun yerine return author.orElse(null) yazılabilir ve aşağıdaki return null; da yazmaya gerek kalmayacak
        return author.map(this::toAuthorResponse).orElse(null);
    }

    @Override
    public AuthorResponse add(AuthorRequest authorRequest) {
        Author author=new Author();
        author.setName(authorRequest.getName());
        return toAuthorResponse(authorRepository.save(author));
    }

    @Override
    public AuthorResponse update(Long id, Author author) {
        Optional<Author>inDbAuthor=authorRepository.findById(id);
        if (inDbAuthor.isPresent()){
            Author author1=inDbAuthor.get();
            author1.setName(author.getName());
            return toAuthorResponse(authorRepository.save(author1));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);

    }
    public AuthorListResponse toAuthorListResponse(Author author){
        AuthorListResponse authorListResponse=new AuthorListResponse();
        authorListResponse.setId(author.getId());
        authorListResponse.setName(author.getName());
        return authorListResponse;
    }

    public AuthorResponse toAuthorResponse(Author author){
        AuthorResponse authorResponse=new AuthorResponse();
        authorResponse.setId(author.getId());
        authorResponse.setName(author.getName());
        return authorResponse;
    }

    public Author getAuthorById(Long id){

        return authorRepository.findById(id).orElse(null);
    }

    public List<BookListResponse> getAuthorBookList(Long id){
        Optional<Author> author=authorRepository.findById(id);
        List<BookListResponse> bookListResponses=new ArrayList<>();
        if (author.isPresent()){
            List<Book> bookList=author.get().getBookList();
            for (Book book:bookList){
                BookListResponse bookListResponse= BookModel.toBookListResponse(book);
                bookListResponses.add(bookListResponse);
            }
            return bookListResponses;
        }
        return null;
    }
}
