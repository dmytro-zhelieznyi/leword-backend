package com.qozz.leword.util;

import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.data.entity.Category;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CategoryMapper {

    public static List<CategoryDto> toCategoriesDto(List<Category> categories) {
        return categories.stream()
                .map(CategoryMapper::toCategoryDto)
                .toList();
    }

    public static CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .valueNo(category.getValueNo())
                .valueEn(category.getValueEn())
                .build();
    }

    public static List<Category> toCategories(List<CategoryDto> categoriesDto) {
        return categoriesDto.stream()
                .map(CategoryMapper::toCategory)
                .toList();
    }

    public static Category toCategory(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .valueNo(categoryDto.getValueNo())
                .valueEn(categoryDto.getValueEn())
                .build();
    }

}
