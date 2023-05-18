package kyu7;

public class MiddleCharacter {
    public static String getMiddle(String word) {
        int startIndex = Math.floorDiv(word.length()-1, 2);
        int endIndex;
        if (word.length() % 2 == 0) {
            endIndex = startIndex + 2;
        } else {
            endIndex = startIndex + 1;
        }
        return word.substring(startIndex, endIndex);
    }
}
