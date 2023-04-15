package kyu7;

public class DisemvovelTrolls {
    public static String disemvowel(String str) {
        return str.replaceAll("(?i)[aeiou]", "");
    }
}
