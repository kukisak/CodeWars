package kyu6;

import kyu6.FindOddNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindOddNumberTest {
    @ParameterizedTest(name = "expected {0} with input {1}")
    @MethodSource("testCases")
    public void findTest(int expected, int[] input) {
        assertEquals(expected, FindOddNumber.findIt(input));
        assertEquals(expected, FindOddNumber.findItClever(input));
        assertEquals(expected, FindOddNumber.findItClever2(input));
        assertEquals(expected, FindOddNumber.findItClever3(input));
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(5, new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}),
            Arguments.of(-1, new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}),
            Arguments.of(5, new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}),
            Arguments.of(10, new int[]{10}),
            Arguments.of(10, new int[]{1,1,1,1,1,1,10,1,1,1,1}),
            Arguments.of(1, new int[]{5,4,3,2,1,5,4,3,2,10,10})
        );
    }
}