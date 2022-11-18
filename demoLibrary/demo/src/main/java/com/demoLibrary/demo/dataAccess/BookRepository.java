package com.demoLibrary.demo.dataAccess;

import com.demoLibrary.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Long> {
    boolean existsByNameIgnoreCase(String name);
}
