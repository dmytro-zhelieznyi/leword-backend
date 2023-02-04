package com.qozz.leword.data.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class CategoryDto {

    private Long id;
    private String valueNo;
    private String valueEn;

}
