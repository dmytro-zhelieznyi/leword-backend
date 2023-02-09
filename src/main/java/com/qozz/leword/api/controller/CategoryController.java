package com.qozz.leword.api.controller;

import com.qozz.leword.api.request.GetAllCategoriesRequestBody;
import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(
            @RequestBody GetAllCategoriesRequestBody requestBody
    ) {
        List<CategoryDto> categoriesDto = categoryService.findAll(requestBody);
        return new ResponseEntity<>(categoriesDto, HttpStatus.OK);
    }

}
