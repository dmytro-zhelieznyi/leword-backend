package com.qozz.leword.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value_no", unique = true, nullable = false)
    private String valueNo;
    @Column(name = "value_en", unique = true, nullable = false)
    private String valueEn;
    @ManyToOne
    @JoinColumn(name = "cateogory_id")
    private Category category;

}
