package kyu7;

public class Vowels {
    public static int getCount(String str) {
        int countResult = 0;
        String vowels = "aeiou";
        for (char c : str.toCharArray()) {
            if (vowels.contains(String.valueOf(c))) {
                countResult++;
            }
        }
        return countResult;
    }

    public static int getCountClever(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }

    public static int getCountBest(String str) {
        return (int)str.chars().filter(ch -> "aeiou".contains(String.valueOf(ch))).count();
    }

    public static int getCountBest2(String str) {
        return (int)str.chars().filter(ch -> "aeiou".indexOf(ch) >= 0).count();
    }


}
