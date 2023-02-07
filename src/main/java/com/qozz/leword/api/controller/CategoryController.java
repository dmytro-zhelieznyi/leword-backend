package com.qozz.leword.api.controller;

import com.qozz.leword.data.dto.CategoryDto;
import com.qozz.leword.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAllCategories(
            @RequestParam(name = "userId", required = false) Long userId) {
        List<CategoryDto> categoriesDto = categoryService.findAll(userId);
        return new ResponseEntity<>(categoriesDto, HttpStatus.OK);
    }

}
