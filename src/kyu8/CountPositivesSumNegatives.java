package kyu8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountPositivesSumNegatives {
    public int[] countPositivesSumNegatives(int[] input)
    {
        if (input == null || input.length == 0) {
            return new int[] {};
        }
        final Integer[] countPositivesSumNegatives = {0,0};
        Arrays.stream(input).forEach(number -> {
            if (number > 0) {
                countPositivesSumNegatives[0]++;
            } else if (number < 0) {
                countPositivesSumNegatives[1] += number;
            }
        });
        //return an array with count of positives and sum of negatives
//        return Arrays.stream(countPositivesSumNegatives).mapToInt(Integer::intValue).toArray();
        return new int[] {countPositivesSumNegatives[0], countPositivesSumNegatives[1]};
    }

    public int[] countBest(int[] input) {
        if (input == null || input.length == 0) {
            return new int[] {};
        }
        int count = 0, sum = 0;
        for (int i : input) {
            if (i > 0) count++;
            if (i < 0) sum += i;
        }
        return new int[] {count, sum};
    }

    public int[] countClever(int[] input) {
        if (input == null || input.length == 0) {
            return new int[] {};
        }
        return new int[] {
                (int) IntStream.of(input).filter(i -> i > 0).count(),
                IntStream.of(input).filter(i -> i < 0).sum()};
    }
}
