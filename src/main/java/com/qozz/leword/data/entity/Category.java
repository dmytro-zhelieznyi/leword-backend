package com.qozz.leword.data.entity;

import com.qozz.leword.data.entity.mtm.UserCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value_no", unique = true, nullable = false)
    private String valueNo;
    @Column(name = "value_en", unique = true, nullable = false)
    private String valueEn;

    @OneToMany(mappedBy = "category")
    private Set<UserCategory> userCategories;

}
