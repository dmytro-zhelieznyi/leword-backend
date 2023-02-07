package com.qozz.leword.repository.specification;

import com.qozz.leword.data.entity.Category_;
import com.qozz.leword.data.entity.User_;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.Word_;
import com.qozz.leword.data.entity.mtm.UserCategory_;
import com.qozz.leword.data.entity.mtm.UserWord_;
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
public class WordSpecification implements Specification<Word> {

    private Set<Long> wordIds;

    @Override
    public Predicate toPredicate(Root<Word> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Set<Predicate> predicates = new HashSet<>();

        if (wordIds != null && !wordIds.isEmpty()) {
            Predicate wordIDS = root.get(Word_.ID)
                    .in(wordIds);
            predicates.add(wordIDS);
        }

        return cb.and(predicates.toArray(new Predicate[]{}));
    }

}
