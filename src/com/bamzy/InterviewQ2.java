package com.bamzy;

import java.util.function.LongBinaryOperator;

public class InterviewQ2 {
    private static LongBinaryOperator addLongs = (t, u) -> t + u;

    public static long add(int a, int b) {
        return addLongs.applyAsLong(a, b);
    }
}
