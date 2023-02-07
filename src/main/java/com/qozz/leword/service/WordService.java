package com.qozz.leword.service;

import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.repository.UserWordRepository;
import com.qozz.leword.repository.specification.UserWordSpecification;
import com.qozz.leword.util.WordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WordService {

    private final UserWordRepository userWordRepository;

    public List<WordDto> findAll(Long userId, Set<Long> categoriesId) {
        List<UserWord> userWords = userWordRepository
                .findAll(new UserWordSpecification(userId, categoriesId));
        List<WordDto> wordDtos = WordMapper.userWordsToWordDtos(userWords);
        return wordDtos;
    }

}
