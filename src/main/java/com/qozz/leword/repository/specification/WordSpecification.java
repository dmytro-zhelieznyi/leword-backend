package com.qozz.leword.repository.specification;

import com.qozz.leword.data.entity.Category_;
import com.qozz.leword.data.entity.User_;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.Word_;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WordSpecification implements Specification<Word> {

    private Long userId;
    private Set<Long> categoriesId;

    @Override
    public Predicate toPredicate(Root<Word> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Set<Predicate> predicates = new HashSet<>();

        root.fetch(Word_.CATEGORY, JoinType.INNER)
                .fetch(Category_.USERS, JoinType.INNER);

        Predicate categoriesID = root.get(Word_.CATEGORY)
                .get(Category_.ID)
                .in(categoriesId);

        if (categoriesId != null && categoriesId.isEmpty()) {
            predicates.add(categoriesID);
        }

        Predicate userID = root.join(Word_.CATEGORY)
                .join(Category_.USERS)
                .get(User_.ID)
                .in(userId);

        if (userId != null) {
            predicates.add(userID);
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }

}
