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
//public class WordNoun extends Word {
//
//    @Column(name = "singular_indefinite")
//    private String singularIndefinite;
//    @Column(name = "singular_particular")
//    private String singularParticular;
//    @Column(name = "plural_indefinite")
//    private String pluralIndefinite;
//    @Column(name = "plural_particular")
//    private String pluralParticular;
//
//    @Builder
//    public WordNoun(Long id, String valueNo, String valueEn,
//                    WordType type, Category category,
//                    String singularIndefinite, String singularParticular,
//                    String pluralIndefinite, String pluralParticular) {
//        super(id, valueNo, valueEn, type, category);
//        this.singularIndefinite = singularIndefinite;
//        this.singularParticular = singularParticular;
//        this.pluralIndefinite = pluralIndefinite;
//        this.pluralParticular = pluralParticular;
//    }
//
//
//}
