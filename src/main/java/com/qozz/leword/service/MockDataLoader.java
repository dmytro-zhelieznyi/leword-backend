package com.qozz.leword.service;

import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.User;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.key.UserCategoryId;
import com.qozz.leword.data.entity.key.UserWordId;
import com.qozz.leword.data.entity.mtm.UserCategory;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class MockDataLoader {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final UserCategoryRepository userCategoryRepository;
    private final WordRepository wordRepository;
    private final UserWordRepository userWordRepository;

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

        List<Category> categories = LongStream.rangeClosed(1, 6)
                .boxed()
                .map(num -> Category.builder().id(num)
                        .valueNo("cNo-" + num)
                        .valueEn("cEn-" + num)
                        .build())
                .toList();

        categoryRepository.saveAll(categories);

        List<UserCategory> userCategories = categories.stream()
                .map(category -> UserCategory.builder()
                        .id(UserCategoryId.builder()
                                .userId(category.getId() % 2 == 0 ? 1L : 2L)
                                .categoryId(category.getId())
                                .build())
                        .user(category.getId() % 2 == 0 ? user : admin)
                        .category(category)
                        .build())
                .toList();

        userCategoryRepository.saveAll(userCategories);

        List<Word> words = categories.stream()
                .flatMap(category -> LongStream.rangeClosed(1, 3)
                        .boxed()
                        .map(num -> Word.builder()
                                .id(null)
                                .valueNo("c" + category.getId() + "-valueNo-" + num)
                                .valueEn("c" + category.getId() + "-valueEn-" + num)
                                .category(category)
                                .build()))
                .toList();

        wordRepository.saveAll(words);

        List<UserWord> userWords = words.stream()
                .map(word -> UserWord.builder()
                        .id(UserWordId.builder()
                                .userId(word.getId() % 2 == 0 ? 1L : 2L)
                                .wordId(word.getId())
                                .build())
                        .user(word.getId() % 2 == 0 ? user : admin)
                        .word(word)
                        .repeat((int) (word.getId() % 2))
                        .lastRepeatTime(LocalDateTime.now())
                        .nextRepeatTIme(LocalDateTime.now().plusHours(1L))
                        .build())
                .toList();

        userWordRepository.saveAll(userWords);


//        List<UserWord> userWords = words.stream()
//                .map(word -> UserWord.builder()
//                        .id(null)
//                        .wordId(word.getId())
//                        .userId(word.getId() % 2 == 0 ? 1L : 2L)
//                        .repeat((int) (word.getId() % 5))
//                        .build())
//                .toList();
//
//        userWordRepository.saveAll(userWords);

//        File lewordData;
//        List<String> lewordDataLines;
//
//        try {
//            lewordData = new File(getClass().getClassLoader().getResource("leword-data.csv").toURI());
//            lewordDataLines = Files.readAllLines(Paths.get(lewordData.getAbsolutePath()));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//        List<Map<String, String>> maps = lewordDataLines.stream()
//                .skip(1)
//                .map(s -> {
//                    String[] split = s.split(",");
//                    Map<String, String> map = new HashMap<>();
//                    map.put("id", split[0]);
//                    map.put("valueNo", split[1]);
//                    map.put("valueEn", split[2]);
//                    map.put("type", split[3]);
//                    map.put("category", split[4]);
//                    map.put("singularIndefinite", split[5]);
//                    map.put("singularParticular", split[6]);
//                    map.put("pluralIndefinite", split[7]);
//                    map.put("pluralParticular", split[8]);
//                    map.put("presentTense", split[9]);
//                        map.put("pastTense", split[10]);
//                        map.put("pastParticiple", split[11]);
//                        map.put("singularMasculine", split[12]);
//                        map.put("singularFeminine", split[13]);
//                        map.put("singularNeuter", split[14]);
//                        map.put("plural", split[15]);
//                        map.put("subjectForm", split[16]);
//                        map.put("objectForm", split[17]);
//                        return map;
//                    }).toList();
//
//            List<Word> words = new ArrayList<>();
//
//            maps.forEach(map -> {
//                Word word = Word.builder()
//                        .id(Long.valueOf(map.get("id")))
//                        .valueNo(map.get("valueNo"))
//                        .valueEn(map.get("valueEn"))
//                        .type(WordType.valueOf(map.get("type")))
//                        .category(categories.stream()
//                                .filter(category -> category.getValueEn().equals(map.get("category")))
//                                .findFirst()
//                                .orElse(null))
//                        .singularIndefinite(map.get("singularIndefinite"))
//                        .singularParticular(map.get("singularParticular"))
//                        .pluralIndefinite(map.get("pluralIndefinite"))
//                        .pluralParticular(map.get("pluralParticular"))
//                        .presentTense(map.get("presentTense"))
//                        .pastTense(map.get("pastTense"))
//                        .pastParticiple(map.get("pastParticiple"))
//                        .singularMasculine(map.get("singularMasculine"))
//                        .singularFeminine(map.get("singularFeminine"))
//                        .singularNeuter(map.get("singularNeuter"))
//                        .plural(map.get("plural"))
//                        .subjectForm(map.get("subjectForm"))
//                        .objectForm(map.get("objectForm"))
//                        .build();
//                words.add(word);
//            });

//        wordRepository.saveAll(words);
//
//        List<UserWord> userWords = words.stream()
//                .map(word -> UserWord.builder()
//                        .id(null)
//                        .userId(admin.getId())
//                        .wordId(word.getId())
//                        .repeat(2)
//                        .build())
//                .toList();
//
//        userWordRepository.saveAll(userWords);
    }
}
