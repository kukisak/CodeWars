package kyu7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumBetweenTwoNegativesTest {
    @MethodSource
    @ParameterizedTest
    void testBasic(int expected, int[] input) {
        assertEquals(expected, MaxSumBetweenTwoNegatives.maxSum(input));
    }

    public static Stream<Arguments> testBasic() {
        return Stream.of(
                Arguments.of(8, new int[] { -1, 6, -2, 3, 5, -7 }),
                Arguments.of(0, new int[] { 5, -1, -2 }),
                Arguments.of(-1, new int[] { 1, -2 })
        );
    }


}