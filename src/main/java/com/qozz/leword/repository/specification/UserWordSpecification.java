package com.qozz.leword.repository.specification;

import com.qozz.leword.api.request.GetAllWordsRequestBody;
import com.qozz.leword.data.entity.Category_;
import com.qozz.leword.data.entity.User_;
import com.qozz.leword.data.entity.Word_;
import com.qozz.leword.data.entity.mtm.UserWord;
import com.qozz.leword.data.entity.mtm.UserWord_;
import com.qozz.leword.data.enumeration.RepeatInterval;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWordSpecification implements Specification<UserWord> {

    private GetAllWordsRequestBody requestBody;

    @Override
    public Predicate toPredicate(Root<UserWord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Set<Predicate> predicates = new HashSet<>();

        var userId = requestBody.userId();
        var categoryIds = requestBody.categoryIds();
        var isLearning = requestBody.isLearning();

        root.fetch(UserWord_.USER);
        root.fetch(UserWord_.WORD)
                .fetch(Word_.CATEGORY);

        if (userId != null) {
            Path<Long> userIdPath = root.get(UserWord_.USER)
                    .get(User_.ID);
            Predicate predicate = cb.equal(userIdPath, userId);
            predicates.add(predicate);
        }

        if (categoryIds != null && !categoryIds.isEmpty()) {
            Predicate predicate = root.get(UserWord_.WORD)
                    .get(Word_.CATEGORY)
                    .get(Category_.ID)
                    .in(categoryIds);
            predicates.add(predicate);
        }

        if (isLearning != null && isLearning) {
            Predicate predicateRepeat =
                    cb.lessThan(root.get(UserWord_.REPEAT), RepeatInterval.UNREACHED_REPEAT);
            Predicate predicateRepeatTime
                    = cb.lessThan(root.get(UserWord_.NEXT_REPEAT_TIME), LocalDateTime.now());

            predicates.add(predicateRepeat);
            predicates.add(predicateRepeatTime);
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
