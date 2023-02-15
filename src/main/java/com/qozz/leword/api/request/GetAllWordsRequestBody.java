package com.qozz.leword.api.request;

import java.util.Set;

public record GetAllWordsRequestBody(
        Long userId,
        Set<Long> categoryIds,
        Boolean isLearning
) {
}
