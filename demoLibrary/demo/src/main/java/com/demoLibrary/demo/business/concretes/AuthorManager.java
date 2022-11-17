package com.demoLibrary.demo.business.concretes;

import com.demoLibrary.demo.business.abstracts.AuthorService;
import com.demoLibrary.demo.dataAccess.AuthorRepository;
import com.demoLibrary.demo.dtos.author.response.AuthorListResponse;
import com.demoLibrary.demo.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorManager implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorManager(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return author.get();
        }//veya if bloğunun yerine return author.orElse(null) yazılabilir ve aşağıdaki return null; da yazmaya gerek kalmayacak
        return null;
    }

    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        Optional<Author>inDbAuthor=authorRepository.findById(id);
        if (inDbAuthor.isPresent()){
            Author author1=inDbAuthor.get();
            author1.setName(author.getName());
            return authorRepository.save(author1);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);

    }
    public AuthorListResponse toAuthorListResponse(Author author){
        AuthorListResponse authorListResponse=new AuthorListResponse();
        authorListResponse
        return authorListResponse;
    }
}
