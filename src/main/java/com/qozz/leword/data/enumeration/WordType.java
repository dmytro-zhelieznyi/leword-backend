package com.qozz.leword.data.enumeration;

public enum WordType {

    NOUN("noun", "substantiv"),
    VERB("verb", "verb"),
    ADJECTIVE("adjective", "adjektiv"),
    PRONOUN("pronoun", "pronomen"),
    ADVERB("adverb", "adverb"),
    PREPOSITION("preposition", "preposisjon"),
    CONJUNCTION("conjunction", "konjunksjon"),
    INTERJECTION("interjection", "interjeksjon"),
    DETERMINATIVE("determinative", "determinativ"),
    SUBJUNCTIVE("subjunctive", "subjunksjonar");

    private final String valueEn;
    private final String valueNo;

    WordType(String valueEn, String valueNo) {
        this.valueEn = valueEn;
        this.valueNo = valueNo;
    }

}
