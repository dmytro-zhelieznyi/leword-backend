package com.qozz.leword.repository;

import com.qozz.leword.data.entity.Word;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findAll(Specification<Word> spec);

}
