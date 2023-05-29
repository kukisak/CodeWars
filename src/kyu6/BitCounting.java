package kyu6;

import java.util.Arrays;

public class BitCounting {
    public static int countBits(int n){
        return Arrays.stream(Integer.toBinaryString(n).split(""))
                .mapToInt(Integer::parseInt)
                .filter(i -> i == 1)
                .sum();
    }

    public static int countBitsClever(int n) {
        return Integer.bitCount(n);
    }

    public static int countBitsSmart(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }
}
