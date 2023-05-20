package kyu6;

import java.util.stream.IntStream;

public class MultipliesOf3and5 {
    public int solution(int number) {
        if (number <= 0) {
            return 0;
        }
        return IntStream.range(3, number)
                .filter(val -> isMultiplyOf(val, 3) || isMultiplyOf(val, 5))
                .sum();
    }

    public boolean isMultiplyOf(int testedNumber, int multiplyBy) {
        return testedNumber % multiplyBy == 0;
    }
}
