package com.qozz.leword.data.entity.mtm;

import com.qozz.leword.data.entity.User;
import com.qozz.leword.data.entity.Word;
import com.qozz.leword.data.entity.key.UserWordId;
import jakarta.persistence.*;
import lombok.*;

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

}
