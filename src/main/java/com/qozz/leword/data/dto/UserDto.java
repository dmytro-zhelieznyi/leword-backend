package com.qozz.leword.data.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDto {

    private Long id;
    private String email;
    private String password;

}
