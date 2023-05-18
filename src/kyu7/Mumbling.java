package kyu7;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mumbling {
    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, s.length()).forEach(index -> {
            char symbol = s.charAt(index);
            sb.append(Character.toUpperCase(symbol));
            for (int i = 1; i <= index; i++) {
                sb.append(Character.toLowerCase(symbol));
            }
            if (index < s.length()-1) {
                sb.append("-");
            }
        });
        return sb.toString();
    }

    public static String accumClever(String s) {
        var chars = s.split("");
        return IntStream.range(0, s.length())
                .mapToObj(i -> chars[i].toUpperCase() + chars[i].toLowerCase().repeat(i))
                .collect(Collectors.joining("-"));
    }
}
