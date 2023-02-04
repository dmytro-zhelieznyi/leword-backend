package com.qozz.leword.data.entity;

import com.qozz.leword.data.enumeration.WordType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value_no", unique = true, nullable = false)
    private String valueNo;
    @Column(name = "value_en", unique = true, nullable = false)
    private String valueEn;

    @Enumerated(EnumType.STRING)
    private WordType type;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

    // NOUN TYPE
    @Column(name = "singular_indefinite")
    private String singularIndefinite;
    @Column(name = "singular_particular")
    private String singularParticular;
    @Column(name = "plural_indefinite")
    private String pluralIndefinite;
    @Column(name = "plural_particular")
    private String pluralParticular;

    // VERB TYPE
    @Column(name = "present_tense")
    private String presentTense;
    @Column(name = "past_tense")
    private String pastTense;
    @Column(name = "past_participle")
    private String pastParticiple;

    // ADJECTIVE TYPE
    @Column(name = "singular_masculine")
    private String singularMasculine;
    @Column(name = "singular_feminine")
    private String singularFeminine;
    @Column(name = "singular_neuter")
    private String singularNeuter;
    @Column(name = "plural")
    private String plural;

    // PRONOUN TYPE
    @Column(name = "subject_form")
    private String subjectForm;
    @Column(name = "object_form")
    private String objectForm;

    // ADVERB TYPE
    // ... nothing

    // PREPOSITION TYPE
    // ... nothing

    // CONJUNCTION TYPE
    // ... nothing

    // INTERJECTION TYPE
    // ... nothing

    // DETERMINATIVE TYPE
    // ... nothing

    // SUBJUNCTIVE TYPE
    // ... nothing

}
