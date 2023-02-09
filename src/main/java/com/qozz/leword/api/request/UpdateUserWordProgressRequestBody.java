package com.qozz.leword.api.request;

public record UpdateUserWordProgressRequestBody(
        Long userId,
        Long wordId,
        Boolean isWordLearned
) {
}
