package com.qozz.leword.service;

import com.qozz.leword.entity.Category;
import com.qozz.leword.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        return optionalCategory.get();
    }

    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        category.setId(id);
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        categoryRepository.deleteById(id);
    }

}
