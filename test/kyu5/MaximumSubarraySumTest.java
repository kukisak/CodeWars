package kyu5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArraySumTest {
    @ParameterizedTest
    @MethodSource("cases")
    void testExampleArray(int expected, int[] input) {
        assertEquals(expected, MaximumSubArraySum.sequence(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    void testExampleArrayClever(int expected, int[] input) {
        assertEquals(expected, MaximumSubArraySum.sequenceClever(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    void testExampleArrayStreamClever(int expected, int[] input) {
        assertEquals(expected, MaximumSubArraySum.sequenceCleverViaStream(input));
    }

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(0, new int[]{}),
                Arguments.of(6, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})
        );
    }

}