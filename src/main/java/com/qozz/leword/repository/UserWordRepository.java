package com.qozz.leword.repository;

import com.qozz.leword.data.entity.key.UserWordId;
import com.qozz.leword.data.entity.mtm.UserWord;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserWordRepository extends JpaRepository<UserWord, UserWordId> {

    List<UserWord> findAll(Specification<UserWord> spec);

}
