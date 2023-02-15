package com.qozz.leword.repository.specification;

import com.qozz.leword.api.request.GetAllCategoriesRequestBody;
import com.qozz.leword.data.entity.User_;
import com.qozz.leword.data.entity.mtm.UserCategory;
import com.qozz.leword.data.entity.mtm.UserCategory_;
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
public class UserCategorySpecification implements Specification<UserCategory> {

    private GetAllCategoriesRequestBody requestBody;

    @Override
    public Predicate toPredicate(Root<UserCategory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Set<Predicate> predicates = new HashSet<>();

        var userId = requestBody.userId();

        root.fetch(UserCategory_.USER);
        root.fetch(UserCategory_.CATEGORY);

        if (userId != null) {
            Path<Long> userIdPath = root.get(UserCategory_.USER)
                    .get(User_.ID);
            Predicate userID = cb.equal(userIdPath, userId);
            predicates.add(userID);
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }
}
