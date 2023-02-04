package com.qozz.leword.repository.specification;

import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.Category_;
import com.qozz.leword.data.entity.User_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorySpecification implements Specification<Category> {

    private Long userId;

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Set<Predicate> predicates = new HashSet<>();

        Predicate userID = root.join(Category_.USERS)
                .get(User_.ID)
                .in(userId);

        if (userId != null) {
            predicates.add(userID);
        }
        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
