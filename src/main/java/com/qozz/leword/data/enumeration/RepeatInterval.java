package com.qozz.leword.data.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum RepeatInterval {

    _0(0, 1L),
    _1(1, 5L),
    _2(2, 15L),
    _3(3, 60L),
    _4(4, 60L * 6),
    _5(5, 60L * 24),
    _6(6, 60L * 24 * 3),
    _7(7, 60L * 24 * 7),
    _8(8, 60L * 24 * 30);

    public static final int MIN_REPEAT = 0;
    public static final int MAX_REPEAT = 8;
    public static final int UNREACHED_REPEAT = 9;

    private static final Map<Integer, Long> AMOUNT_TIME = new HashMap<>();

    static {
        for (RepeatInterval e: values()) {
            AMOUNT_TIME.put(e.repeatAmount, e.additionalTime);
        }
    }

    private final int repeatAmount;
    private final long additionalTime;


    RepeatInterval(int repeatAmount, long additionalTime) {
        this.repeatAmount = repeatAmount;
        this.additionalTime = additionalTime;
    }

    public static Long additionalTime(int repeatAmount) {
        return AMOUNT_TIME.get(repeatAmount);
    }

}
