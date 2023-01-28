package com.qozz.leword.service;

import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.User;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.repository.CategoryRepository;
import com.qozz.leword.repository.UserRepository;
import com.qozz.leword.repository.WordRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class MockDataLoader {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final WordRepository wordRepository;

    @PostConstruct
    public void postConstructor() {
        User user = User.builder()
                .id(null)
                .email("user@gmail.com")
                .password("user")
                .build();

        userRepository.save(user);

        List<Category> categories = LongStream.rangeClosed(1, 15)
                .boxed()
                .map(num -> Category.builder().id(num)
                        .valueNo("categoryNo-" + num)
                        .valueEn("categoryEn-" + num)
                        .user(user)
                        .build())
                .toList();

        categoryRepository.saveAll(categories);

        List<Word> words = categories.stream()
                .map(category -> LongStream.rangeClosed(1, 50)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-wordNo-" + num)
                                .valueEn(category.getId() + "-wordEn-" + num)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        wordRepository.saveAll(words);
    }

}
