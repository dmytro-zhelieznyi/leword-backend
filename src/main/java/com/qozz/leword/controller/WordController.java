package com.qozz.leword.controller;

import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/words")
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

