package com.qozz.leword.service;

import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.repository.UserWordRepository;
import com.qozz.leword.repository.WordRepository;
import com.qozz.leword.repository.specification.UserWordSpecification;
import com.qozz.leword.util.WordMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;
    private final UserWordRepository userWordRepository;

    public List<WordDto> findAll(Long userId, Set<Long> categoriesId) {
        List<UserWord> userWords = userWordRepository
                .findAll(new UserWordSpecification(userId, categoriesId));
        List<WordDto> wordDtos = WordMapper.userWordsToWordDtos(userWords);
        return wordDtos;
    }

    public Word findById(Long id) {
        Optional<Word> optionalWord = wordRepository.findById(id);
        if (optionalWord.isEmpty()) {
            throw new EntityNotFoundException("Word not found for id : " + id);
        }
        return optionalWord.get();
    }

    public Word create(Word word) {
        return wordRepository.save(word);
    }

    public Word update(Long id, Word word) {
        Optional<Word> optionalWord = wordRepository.findById(id);
        if (optionalWord.isEmpty()) {
            throw new EntityNotFoundException("Word not found for id : " + id);
        }
        word.setId(id);
        return wordRepository.save(word);
    }


    public void delete(Long id) {
        Optional<Word> optionalWord = wordRepository.findById(id);
        if (optionalWord.isEmpty()) {
            throw new EntityNotFoundException("Word not found for id : " + id);
        }
        wordRepository.deleteById(id);
    }

}
