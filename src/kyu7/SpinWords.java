package kyu7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {
    public String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(word -> {
                    if (word.length() >= 5) {
                        return new StringBuilder(word).reverse().toString();
                    } else {
                        return word;
                    }
                }).collect(Collectors.joining(" "));
    }
}
