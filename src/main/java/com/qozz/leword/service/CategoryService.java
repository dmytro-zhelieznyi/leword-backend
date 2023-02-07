package com.qozz.leword.service;

import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.mtm.UserCategory;
import com.qozz.leword.repository.CategoryRepository;
import com.qozz.leword.repository.UserCategoryRepository;
import com.qozz.leword.repository.specification.UserCategorySpecification;
import com.qozz.leword.util.CategoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserCategoryRepository userCategoryRepository;

    public List<CategoryDto> findAll(Long userId) {
        List<UserCategory> userCategories = userCategoryRepository.findAll(new UserCategorySpecification(userId));
        List<CategoryDto> categoryDtos = CategoryMapper.userCategoriesToCategoryDtos(userCategories);
        return categoryDtos;
    }

    public CategoryDto findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        return CategoryMapper.categoryToCategoryDto(optionalCategory.get());
    }

    public List<CategoryDto> findAllByUserId(Long id) {
        List<Category> categories = categoryRepository.findAll();
        return CategoryMapper.categoriesToCategoryDtos(categories);
    }

    public CategoryDto create(CategoryDto categoryDto) {
        Category savedCategory = categoryRepository.save(CategoryMapper.categoryDtoToCategory(categoryDto));
        return CategoryMapper.categoryToCategoryDto(savedCategory);
    }

    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        categoryDto.setId(id);
        Category savedCategory = categoryRepository.save(CategoryMapper.categoryDtoToCategory(categoryDto));
        return CategoryMapper.categoryToCategoryDto(categoryRepository.save(savedCategory));
    }

    public void delete(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new EntityNotFoundException("Category not found for id : " + id);
        }
        categoryRepository.deleteById(id);
    }

}
