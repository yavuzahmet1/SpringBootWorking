package com.backend.library.Service;

import com.backend.library.entity.Category;
import com.backend.library.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public Category loadCategory(Long id){
        return categoryRepository.
    }
}
