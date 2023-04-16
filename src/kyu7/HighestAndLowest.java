package kyu7;

import java.util.Arrays;

public class HighestAndLowest {
    public static String highAndLow(String numbers) {
        String[] numbersArray = numbers.split(" ");
        final Integer[] result = {Integer.parseInt(numbersArray[0]), Integer.parseInt(numbersArray[0])};
        Arrays.stream(numbersArray).mapToInt(Integer::parseInt).forEach(value -> {
            if (value < result[0]) {
                result[0] = value;
            } else if (value > result[1]) {
                result[1] = value;
            }
        });
        return result[1] + " " + result[0];
    }

    public static String highAndLowBest(String numbers) {
        String[] numbersArray = numbers.split(" ");
        int min = Integer.parseInt(numbersArray[0]);
        int max = min;
        for (String s : numbersArray) {
            int value = Integer.parseInt(s);
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return max + " " + min;
    }

    public static String highAndLowClever(String numbers) {
        var stats = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }
}
