package com.qozz.leword.data.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserCategoryId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "category_id")
    private Long categoryId;

}
