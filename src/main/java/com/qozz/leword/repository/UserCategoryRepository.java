package com.qozz.leword.repository;

import com.qozz.leword.data.entity.key.UserCategoryId;
import com.qozz.leword.data.entity.mtm.UserCategory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCategoryRepository extends JpaRepository<UserCategory, UserCategoryId> {

    List<UserCategory> findAll(Specification<UserCategory> spec);

}
