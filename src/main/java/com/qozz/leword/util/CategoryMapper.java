package com.qozz.leword.util;

import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.mtm.UserCategory;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CategoryMapper {

    public static List<CategoryDto> userCategoriesToCategoryDtos(List<UserCategory> userCategories) {
        return userCategories.stream()
                .map(CategoryMapper::userCategoryToCategoryDto)
                .toList();
    }

    public static CategoryDto userCategoryToCategoryDto(UserCategory userCategory) {
        Category category = userCategory.getCategory();
        return CategoryDto.builder()
                .id(category.getId())
                .valueNo(category.getValueNo())
                .valueEn(category.getValueEn())
                .build();
    }

    public static List<CategoryDto> categoriesToCategoryDtos(List<Category> categories) {
        return categories.stream()
                .map(CategoryMapper::categoryToCategoryDto)
                .toList();
    }

    public static CategoryDto categoryToCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .valueNo(category.getValueNo())
                .valueEn(category.getValueEn())
                .build();
    }

    public static List<Category> categoryDtosToCategories(List<CategoryDto> categoryDtos) {
        return categoryDtos.stream()
                .map(CategoryMapper::categoryDtoToCategory)
                .toList();
    }

    public static Category categoryDtoToCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .valueNo(categoryDto.getValueNo())
                .valueEn(categoryDto.getValueEn())
                .build();
    }

}
