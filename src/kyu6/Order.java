package kyu6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static int extractNumber(String input) {
        return Integer.parseInt(input.replaceAll("\\D", ""));
    }
    public static String order(String words) {
        List<String> list = Arrays.asList(words.split(" "));
        list.sort(Comparator.comparingInt(Order::extractNumber));
        return String.join(" ", list);
    }

    public static String orderClever(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(input -> input.replaceAll("\\D", "")))
                .collect(Collectors.joining(" "));
    }
}
