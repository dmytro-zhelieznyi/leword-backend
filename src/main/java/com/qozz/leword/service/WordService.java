package com.qozz.leword.service;

import com.qozz.leword.api.request.GetAllWordsRequestBody;
import com.qozz.leword.api.request.UpdateUserWordProgressRequestBody;
import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.data.enumeration.RepeatInterval;
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

        userWord.setRepeat(updateRepeat(isWordLearned, userWord.getRepeat()));
        userWord.setLastRepeatTime(LocalDateTime.now());
        userWord.setNextRepeatTime(updateNextRepeatTime(userWord.getRepeat()));

        // TODO add dto for UserWord
    }

    private int updateRepeat(boolean isWordLearned, int repeat) {
        return isWordLearned ?
                updateRepeatPlus(repeat) :
                updateRepeatMinus(repeat);
    }

    private int updateRepeatPlus(int repeat) {
        if (repeat >= RepeatInterval.MAX_REPEAT) return RepeatInterval.UNREACHED_REPEAT;
        return repeat + 1;
    }

    private int updateRepeatMinus(int repeat) {
        if (repeat <= RepeatInterval.MIN_REPEAT) return RepeatInterval.MIN_REPEAT;
        return repeat - 1;
    }

    private LocalDateTime updateNextRepeatTime(Integer repeatAmount) {
        if (repeatAmount < RepeatInterval.MIN_REPEAT) {
            return LocalDateTime.now().plusMinutes(RepeatInterval.additionalTime(0));
        }

        if (repeatAmount > RepeatInterval.MAX_REPEAT) {
            return LocalDateTime.of(0, 1, 1, 0, 0, 1);
        }

        return LocalDateTime.now().plusMinutes(RepeatInterval.additionalTime(repeatAmount));
    }

}
