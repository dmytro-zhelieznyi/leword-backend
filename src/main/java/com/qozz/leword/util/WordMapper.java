package com.qozz.leword.util;

import com.qozz.leword.data.dto.WordDto;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.mtm.UserWord;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class WordMapper {

    public static WordDto userWordToWordDto(UserWord userWord) {
        Word word = userWord.getWord();
        return WordDto.builder()
                .id(word.getId())
                .valueNo(word.getValueNo())
                .valueEn(word.getValueEn())
                .category(word.getCategory().getValueEn())
                // TODO other fields
                .build();
    }

    public static List<WordDto> userWordsToWordDtos(List<UserWord> userWords) {
        return userWords.stream()
                .map(WordMapper::userWordToWordDto)
                .toList();
    }
}
