package kyu6;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringToCamelCase {
    static String toCamelCase(String s){
        String result = Arrays.stream(s.split("[-_]"))
                .filter(str -> !str.isEmpty())
                .map(str -> str.replaceFirst(str.substring(0,1), str.substring(0,1).toUpperCase()))
                .collect(Collectors.joining());
        if (result.isEmpty()) {
            return result;
        }
        return s.charAt(0) + result.substring(1);
    }

    static String toCamelCaseClever(String str) {
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }

    static String toCamelCaseCleverMatcher(String str) {
        return Pattern.compile("[-_](.)").matcher(str).replaceAll(r -> r.group(1).toUpperCase());
    }
}
