package com.qozz.leword.service;

import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.data.entity.Category;
import com.qozz.leword.repository.CategoryRepository;
import com.qozz.leword.util.CategoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAll(Specification<Category> spec) {
        List<Category> categories = categoryRepository.findAll(spec);
        return CategoryMapper.toCategoriesDto(categories);
    }

    public CategoryDto findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        return CategoryMapper.toCategoryDto(optionalCategory.get());
    }

    public List<CategoryDto> findAllByUserId(Long id) {
        List<Category> categories = categoryRepository.findAll();
        return CategoryMapper.toCategoriesDto(categories);
    }

    public CategoryDto create(CategoryDto categoryDto) {
        Category savedCategory = categoryRepository.save(CategoryMapper.toCategory(categoryDto));
        return CategoryMapper.toCategoryDto(savedCategory);
    }

    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        categoryDto.setId(id);
        Category savedCategory = categoryRepository.save(CategoryMapper.toCategory(categoryDto));
        return CategoryMapper.toCategoryDto(categoryRepository.save(savedCategory));
    }

    public void delete(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        categoryRepository.deleteById(id);
    }

}
