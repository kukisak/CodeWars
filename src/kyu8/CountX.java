package kyu8;

import java.util.stream.IntStream;

public class CountX{
    public static int[] countBy(int x, int n){
        // Your code here
        return IntStream.rangeClosed(1,n).map(val -> val * x).toArray();
    }

    public int[] countByVersion2(int x, int n) {
        return IntStream.iterate(x, it -> it + x).limit(n).toArray();
    }
}