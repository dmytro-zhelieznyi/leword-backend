package com.qozz.leword.repository.filter;

import java.util.Set;

public record WordFilter(
        Long userId,
        Set<Long> categoryIds
) {
}
