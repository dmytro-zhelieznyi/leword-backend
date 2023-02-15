package com.qozz.leword.data.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserWordDto {

    private Long userId;
    private Long wordId;
    private Integer repeat;
    private LocalDateTime lastRepeatTime;
    private LocalDateTime nextRepeatTime;

}
