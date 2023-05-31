package kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(text.split(""))
                .map(String::toLowerCase)
                .forEach(c -> map.merge(c, 1, Integer::sum));
        return map.values().stream()
                .map(val -> (val > 1) ? 1 : 0)
                .filter(val -> val > 0)
                .reduce(0, Integer::sum);
    }

    public static int duplicateCountClever(String text) {
        var map = text.codePoints()
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()));
        return (int) map.values().stream()
                .filter(val -> val > 1)
                .count();
    }
}
