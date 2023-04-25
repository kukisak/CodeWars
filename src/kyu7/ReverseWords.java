package kyu7;

import java.util.Arrays;

public class ReverseWords {
    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */

    public static String reverseWords(final String original) {
        // iterate through input String
        // when find space then extract previous characters up to start index
        // revert characters and append them to new string
        // set start index to position of space index
        // continue with iteration
        // detection of spaces and words between them
        //  case " word"
        //  case "word "
        //  case "  word"
        //  case "word  word"
        //  case "word"

        int startIndex = 0;
        StringBuilder result = new StringBuilder(original.length());
        for (int i = 0; i < original.length(); i++) {
            if (isSpace(original, i) && startIndex == i) {
                result.append(' ');
                startIndex = i + 1;
            } else if (isSpace(original, i) && startIndex != i) {
                copySubstring(original, startIndex, result, i - 1);
                result.append(original.charAt(i));
                startIndex = i + 1;
            } else if (i == original.length() - 1 && !isSpace(original, i)) {
                copySubstring(original, startIndex, result, i);
                startIndex = i + 1;
            } else {
                //continue iterating
            }
        }
        return result.toString();
    }

    private static void copySubstring(final String original, int startIndex, StringBuilder result, int lastIndexInclusive) {
        result.append(new StringBuilder(original.substring(startIndex, lastIndexInclusive + 1)).reverse());
    }

    private static boolean isSpace(String input, int index) {
        return input.charAt(index) == ' ';
    }

    public static String reverseWordsBest(final String original) {
        String[] array = original.split(" ");
        if (array.length == 0) {
            return original;
        }
        System.out.println("original = \"" + original + "\"");
        System.out.println("splitted = " + Arrays.toString(array));
        int i = 0;
        for (String s: array) {
            array[i] = new StringBuilder(s).reverse().toString();
            i++;
        }
        StringBuilder result = new StringBuilder(String.join(" ", array));
        boolean stopAppendSpace = false;
        int index = original.length() -1;
        while (!stopAppendSpace && index >= 0) {
            if (original.charAt(index) == ' '){
                result.append(" ");
            } else {
                stopAppendSpace = true;
            }
            index-=1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
    }
}
