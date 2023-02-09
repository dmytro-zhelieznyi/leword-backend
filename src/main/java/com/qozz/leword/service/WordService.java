package com.qozz.leword.service;

import com.qozz.leword.api.request.GetAllWordsRequestBody;
import com.qozz.leword.api.request.UpdateUserWordProgressRequestBody;
import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.repository.UserWordRepository;
import com.qozz.leword.repository.specification.UserWordSpecification;
import com.qozz.leword.util.WordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final UserWordRepository userWordRepository;

    public List<WordDto> findAll(GetAllWordsRequestBody requestBody) {
        List<UserWord> userWords = userWordRepository
                .findAll(new UserWordSpecification(requestBody));
        List<WordDto> wordDtos = WordMapper.userWordsToWordDtos(userWords);
        return wordDtos;
    }

    public UserWord updateUserWordProgress(UpdateUserWordProgressRequestBody requestBody) {
        UserWord userWord = userWordRepository.findById_UserIdAndId_WordId(
                        requestBody.userId(),
                        requestBody.wordId())
                .orElseThrow(() -> new RuntimeException("UserWord doesn't exist. " + requestBody));

        updateUserWordProgress(requestBody, userWord);
        userWordRepository.save(userWord);
        return userWord;
    }

    private void updateUserWordProgress(UpdateUserWordProgressRequestBody requestBody,
                                        UserWord userWord) {
        var isWordLearned = requestBody.isWordLearned();

        userWord.setRepeat(isWordLearned ? userWord.getRepeat() + 1 : userWord.getRepeat() - 1);
        userWord.setLastRepeatTime(LocalDateTime.now());
        // TODO implement logic for nextTimeRepeat;
        userWord.setNextRepeatTime(LocalDateTime.now().plusHours(1L));

        // TODO add dto for UserWord

    }

}
