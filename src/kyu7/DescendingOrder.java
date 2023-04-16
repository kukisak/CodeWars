package kyu7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        return Integer.parseInt(String.valueOf(num).chars()
                .map(Character::getNumericValue)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .reduce("", (a,b) -> a + b));
    }

    public static int sortDescBest(final int num) {
        String[] strings = String.valueOf(num).split("");
        Arrays.sort(strings, Comparator.reverseOrder());
        return Integer.parseInt(String.join("", strings));
    }
    public static int sortDescClever(final int num) {
        return Integer.parseInt(String.valueOf(num).chars()
                .mapToObj(ch -> String.valueOf(Character.getNumericValue(ch)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }
}
