package com.qozz.leword.repository;

import com.qozz.leword.data.entity.key.UserWordId;
import com.qozz.leword.data.entity.mtm.UserWord;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserWordRepository extends JpaRepository<UserWord, UserWordId> {

    List<UserWord> findAll(Specification<UserWord> spec);
    Optional<UserWord> findById_UserIdAndId_WordId(
            @Param(value = "userId") Long userId,
            @Param(value = "wordId") Long wordId
    );

}
