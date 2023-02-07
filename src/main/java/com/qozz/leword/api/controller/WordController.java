package com.qozz.leword.api.controller;

import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/words")
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @GetMapping()
    public ResponseEntity<List<WordDto>> getAllWords(
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "categoryIds", required = false) Set<Long> categoryIds) {
        // TODO add other params (depends on learn time and repeats...)
        List<WordDto> words = wordService.findAll(userId, categoryIds);
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

}

