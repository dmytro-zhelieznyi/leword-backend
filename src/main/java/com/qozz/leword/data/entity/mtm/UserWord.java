package com.qozz.leword.data.entity.mtm;

import com.qozz.leword.data.entity.User;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.key.UserWordId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_word")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserWord {

    @EmbeddedId
    private UserWordId id;

    @ManyToOne
    @MapsId("user_id")
    private User user;

    @ManyToOne
    @MapsId("word_id")
    private Word word;

    @Column(name = "repeat")
    private Integer repeat;

    @Column(name = "last_repeat_time", nullable = false)
    private LocalDateTime lastRepeatTime;

    @Column(name = "next_repeat_time", nullable = false)
    private LocalDateTime nextRepeatTime;

}
