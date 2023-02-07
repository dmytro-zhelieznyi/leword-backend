package com.qozz.leword.repository.specification;

import com.qozz.leword.data.entity.Category_;
import com.qozz.leword.data.entity.User_;
import com.qozz.leword.data.entity.Word_;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.data.entity.mtm.UserWord_;
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
public class UserWordSpecification implements Specification<UserWord> {

    private Long userId;
    private Set<Long> categoryIds;

    @Override
    public Predicate toPredicate(Root<UserWord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Set<Predicate> predicates = new HashSet<>();

        root.fetch(UserWord_.USER);
        root.fetch(UserWord_.WORD)
                .fetch(Word_.CATEGORY);

        if (userId != null) {
            Path<Long> userIdPath = root.get(UserWord_.USER)
                    .get(User_.ID);
            Predicate userID = cb.equal(userIdPath, userId);
            predicates.add(userID);
        }

        if (categoryIds != null && !categoryIds.isEmpty()) {
            Predicate categoryIDs = root.get(UserWord_.WORD)
                    .get(Word_.CATEGORY)
                    .get(Category_.ID)
                    .in(categoryIds);
            predicates.add(categoryIDs);
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
