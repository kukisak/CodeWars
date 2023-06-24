package kyu5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PigLatin {
    public static String pigIt(String str) {
        return Arrays.stream(str.split(" "))
                .map(word -> {
                    Matcher matcher = Pattern.compile("\\w").matcher(Character.toString(word.charAt(0)));
                    if (matcher.matches()) {
                        return word.substring(1) + matcher.group() + "ay";
                    } else {
                        return word + "ay";
                    }
                })
                .collect(Collectors.joining(" "));
    }
    public static String pigItSmart(String str) {
        return Arrays.stream(str.split(" "))
                .map(word -> {
                    Matcher matcher = Pattern.compile("^(\\w)(\\w*)").matcher(word);
                    if (matcher.matches()) {
                        return matcher.group(2) + matcher.group(1) + "ay";
                    } else {
                        return word + "ay";
                    }
                })
                .collect(Collectors.joining(" "));
    }

    public static String pigItClever(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

}
