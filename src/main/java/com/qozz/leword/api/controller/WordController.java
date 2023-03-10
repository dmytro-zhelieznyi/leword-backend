package com.qozz.leword.api.controller;

import com.qozz.leword.api.request.GetAllWordsRequestBody;
import com.qozz.leword.api.request.UpdateUserWordProgressRequestBody;
import com.qozz.leword.data.dto.UserWordDto;
import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @GetMapping
    public ResponseEntity<List<WordDto>> getAllWords(
            @RequestBody GetAllWordsRequestBody requestBody
    ) {
        List<WordDto> words = wordService.findAll(requestBody);
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

    @PostMapping("/progress")
    public ResponseEntity<UserWordDto> updateUserWordProgress(
            @RequestBody UpdateUserWordProgressRequestBody requestBody
    ) {
        UserWordDto userWord = wordService.updateUserWordProgress(requestBody);
        return new ResponseEntity<>(userWord, HttpStatus.OK);
    }

}

