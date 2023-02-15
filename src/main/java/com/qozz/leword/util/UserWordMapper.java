package com.qozz.leword.util;

import com.qozz.leword.data.dto.UserWordDto;
import com.qozz.leword.data.entity.mtm.UserWord;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserWordMapper {

    public static UserWordDto userWordToUserWordDto(UserWord userWord) {
        return UserWordDto.builder()
                .userId(userWord.getId().getUserId())
                .wordId(userWord.getId().getWordId())
                .repeat(userWord.getRepeat())
                .lastRepeatTime(userWord.getLastRepeatTime())
                .nextRepeatTime(userWord.getNextRepeatTime())
                .build();
    }

    public static List<UserWordDto> userWordsToUserWordDtos(List<UserWord> userWords) {
        return userWords.stream()
                .map(UserWordMapper::userWordToUserWordDto)
                .toList();
    }

}
