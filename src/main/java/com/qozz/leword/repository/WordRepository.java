package com.qozz.leword.repository;

import com.qozz.leword.data.entity.Word;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findAll(Specification<Word> spec);

//    @Query(value = "select w.id, w.value_no, w.value_en, w.category_id from user_category as uc " +
//            "inner join category as c on c.id = uc.category_id " +
//            "inner join usr as u on u.id = uc.User_id " +
//            "inner join word as w on w.category_id = c.id",
//            nativeQuery = true)
//@Query(value = "select w from Word w join fetch w.category c join fetch c.users ")
}
