package kyu8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SquareSum {
    public static int squareSum(int[] n)
    {
        return IntStream.of(n).map(i -> i*i).reduce(0, Integer::sum);
    }

    public int squareSumBest(int[] n) {
        return Arrays.stream(n).map(i -> i*i).sum();
    }
}
