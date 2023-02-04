package com.qozz.leword.repository;

import com.qozz.leword.data.entity.Category;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAll(Specification<Category> spec);

}
