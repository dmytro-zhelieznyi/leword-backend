package com.qozz.leword.service;

import com.qozz.leword.api.request.GetAllCategoriesRequestBody;
import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.data.entity.mtm.UserCategory;
import com.qozz.leword.repository.UserCategoryRepository;
import com.qozz.leword.repository.specification.UserCategorySpecification;
import com.qozz.leword.util.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final UserCategoryRepository userCategoryRepository;

    public List<CategoryDto> findAll(GetAllCategoriesRequestBody requestBody) {
        List<UserCategory> userCategories = userCategoryRepository
                .findAll(new UserCategorySpecification(requestBody));
        List<CategoryDto> categoryDtos = CategoryMapper.userCategoriesToCategoryDtos(userCategories);
        return categoryDtos;
    }

}
