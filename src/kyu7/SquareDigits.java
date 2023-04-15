package kyu7;

import java.util.stream.Collectors;

public class SquareDigits {
    public int squareDigits(int n) {
        return Integer.parseInt(String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .mapToObj(num -> String.valueOf(num * num))
                .collect(Collectors.joining()));
    }

    public int squareDigitsBest(int n) {
        StringBuilder result = new StringBuilder();
        char[] chars = String.valueOf(n).toCharArray();
        for (char c : chars) {
            int digit = Character.digit(c, 10);
            result.append(digit * digit);
        }
        return Integer.parseInt(result.toString());
    }
}
