//package com.qozz.leword.data.entity;
//
//import com.qozz.leword.data.enumeration.WordType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import lombok.*;
//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode(callSuper = true)
//public class WordVerb extends Word {
//
//    @Column(name = "present_tense")
//    private String presentTense;
//    @Column(name = "past_tense")
//    private String pastTense;
//    @Column(name = "past_participle")
//    private String pastParticiple;
//
//    @Builder
//    public WordVerb(Long id, String valueNo, String valueEn,
//                    WordType type, Category category,
//                    String presentTense, String pastTense, String pastParticiple) {
//        super(id, valueNo, valueEn, type, category);
//        this.presentTense = presentTense;
//        this.pastTense = pastTense;
//        this.pastParticiple = pastParticiple;
//    }
//
//}
