package kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MorseCodeDecoder {
    final static String[] english = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "1",
            "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?" };

    final static String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.." };
    
    public static final Map<String, String> MorseCode;
    static {
        MorseCode = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            MorseCode.put(morse[i], english[i].toUpperCase());
        }
    }
    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(word -> Arrays.stream(word.split(" "))
                        .map(MorseCode::get)
                        .filter(Objects::nonNull)
                        .reduce("", String::concat))
                .collect(Collectors.joining(" "));
    }
}
