package com.qozz.leword.data.entity.mtm;

import com.qozz.leword.data.entity.Category;
import com.qozz.leword.data.entity.User;
import com.qozz.leword.data.entity.key.UserCategoryId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserCategory {

    @EmbeddedId
    private UserCategoryId id;

    @ManyToOne
    @MapsId("user_id")
    private User user;

    @ManyToOne
    @MapsId("category_id")
    private Category category;

}
