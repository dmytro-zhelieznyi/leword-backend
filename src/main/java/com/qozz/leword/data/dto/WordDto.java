package com.qozz.leword.data.dto;

import com.qozz.leword.data.enumeration.WordType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class WordDto {

    private Long id;
    private String valueNo;
    private String valueEn;

    private WordType type;

    private String category;

    // NOUN TYPE
    private String singularIndefinite;
    private String singularParticular;
    private String pluralIndefinite;
    private String pluralParticular;

    // VERB TYPE
    private String presentTense;
    private String pastTense;
    private String pastParticiple;

    // ADJECTIVE TYPE
    private String singularMasculine;
    private String singularFeminine;
    private String singularNeuter;
    private String plural;

    // PRONOUN TYPE
    private String subjectForm;
    private String objectForm;

}
