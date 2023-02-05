package com.qozz.leword.service;

import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.User;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.enumeration.WordType;
import com.qozz.leword.repository.CategoryRepository;
import com.qozz.leword.repository.UserRepository;
import com.qozz.leword.repository.WordRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
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
                .id(1L)
                .email("user@gmail.com")
                .password("user")
                .build();

        User admin = User.builder()
                .id(2L)
                .email("admin@gmail.com")
                .password("admin")
                .build();

        userRepository.save(user);
        userRepository.save(admin);

        List<Category> categories = LongStream.rangeClosed(1, 15)
                .boxed()
                .map(num -> Category.builder().id(num)
                        .valueNo("categoryNo-" + num)
                        .valueEn("categoryEn-" + num)
                        .users(num % 2 == 0 ? Collections.singleton(user) : Collections.singleton(admin))
                        .build())
                .toList();

        categoryRepository.saveAll(categories);

        List<Word> wordsNoun = categories.stream()
                .map(category -> LongStream.rangeClosed(1, 25)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-nounNo-" + num)
                                .valueEn(category.getId() + "-nounEn-" + num)
                                .type(WordType.NOUN                              )
                                .singularIndefinite("singularIndefinite")
                                .singularParticular("singularParticular")
                                .pluralIndefinite("pluralIndefinite")
                                .pluralParticular("pluralParticular")
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsVerb = categories.stream()
                .map(category -> LongStream.rangeClosed(26, 50)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-verbNo-" + num)
                                .valueEn(category.getId() + "-verbEn-" + num)
                                .type(WordType.VERB)
                                .presentTense("presentTense")
                                .pastTense("pastTense")
                                .pastParticiple("pastParticiple")
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsAdjective = categories.stream()
                .map(category -> LongStream.rangeClosed(51, 75)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-adjectiveNo-" + num)
                                .valueEn(category.getId() + "-adjectiveEn-" + num)
                                .type(WordType.ADJECTIVE)
                                .singularMasculine("singularMasculine")
                                .singularFeminine("singularFeminine")
                                .singularNeuter("singularNeuter")
                                .plural("plural")
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsPronoun = categories.stream()
                .map(category -> LongStream.rangeClosed(76, 100)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-pronounNo-" + num)
                                .valueEn(category.getId() + "-pronounEn-" + num)
                                .type(WordType.PRONOUN)
                                .subjectForm("subjectForm")
                                .objectForm("objectForm")
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsAdverb = categories.stream()
                .map(category -> LongStream.rangeClosed(101, 125)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-adverbNo-" + num)
                                .valueEn(category.getId() + "-adverbEn-" + num)
                                .type(WordType.ADVERB)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsPreposition = categories.stream()
                .map(category -> LongStream.rangeClosed(126, 150)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-prepositionNo-" + num)
                                .valueEn(category.getId() + "-prepositionEn-" + num)
                                .type(WordType.PREPOSITION)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsConjunction = categories.stream()
                .map(category -> LongStream.rangeClosed(151, 175)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-conjunctionNo-" + num)
                                .valueEn(category.getId() + "-conjunctionEn-" + num)
                                .type(WordType.CONJUNCTION)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsInterjection = categories.stream()
                .map(category -> LongStream.rangeClosed(176, 200)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-interjectionNo-" + num)
                                .valueEn(category.getId() + "-interjectionEn-" + num)
                                .type(WordType.INTERJECTION)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsDeterminative = categories.stream()
                .map(category -> LongStream.rangeClosed(201, 225)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-determinativeNo-" + num)
                                .valueEn(category.getId() + "-determinativeEn-" + num)
                                .type(WordType.DETERMINATIVE)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        List<Word> wordsSubjunctive = categories.stream()
                .map(category -> LongStream.rangeClosed(226, 250)
                        .boxed()
                        .map(num -> Word.builder().id(null)
                                .valueNo(category.getId() + "-subjunctiveNo-" + num)
                                .valueEn(category.getId() + "-subjunctiveEn-" + num)
                                .type(WordType.SUBJUNCTIVE)
                                .category(category)
                                .build())
                        .toList())
                .flatMap(Collection::stream)
                .toList();

        wordRepository.saveAll(wordsNoun);
        wordRepository.saveAll(wordsVerb);
        wordRepository.saveAll(wordsAdjective);
        wordRepository.saveAll(wordsPronoun);
        wordRepository.saveAll(wordsAdverb);
        wordRepository.saveAll(wordsPreposition);
        wordRepository.saveAll(wordsConjunction);
        wordRepository.saveAll(wordsInterjection);
        wordRepository.saveAll(wordsDeterminative);
        wordRepository.saveAll(wordsSubjunctive);

    }

}
