package kyu6;

import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class DuplicateEncoder {
    static String encode(String word){
        word = word.toLowerCase();
        var map = word.codePoints()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), counting()));
        return word.codePoints()
                .mapToObj(c -> (char) c)
                .map(ch -> (map.get(ch) > 1) ? ")" : "(")
                .collect(joining());
    }

    static String encodeBest(String word) {
        return word.toLowerCase().chars()
                .mapToObj(i -> String.valueOf((char) i))
                .map(s -> (word.toLowerCase().indexOf(s) == word.toLowerCase().lastIndexOf(s)) ? "(" : ")")
                .collect(joining());
    }

    static String encodeClever(String word) {
        word = word.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sb.append((word.indexOf(c) == word.lastIndexOf(c)) ? "(" : ")");
        }
        return sb.toString();
    }
}
