package com.qozz.leword.repository;

import com.qozz.leword.data.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
