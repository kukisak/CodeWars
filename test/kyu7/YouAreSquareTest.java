package kyu7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class YouAreSquareTest {
    @ParameterizedTest(name = "{0} expected {1} input {2}")
    @MethodSource
    public void shouldWorkForSomeExamples(String message, boolean expected, Integer input) throws Exception {
        assertEquals(expected, YouAreSquare.isSquare(input));
    }


    public static Stream<Arguments> shouldWorkForSomeExamples() throws Exception {
        return Stream.of(
            Arguments.of("negative numbers aren't square numbers", false, -1),
            Arguments.of("0 is a square number (0 * 0)",    true,   0),
            Arguments.of("3 isn't a square number", false,  3),
            Arguments.of("4 is a square number (2 * 2)",    true,   4),
            Arguments.of("25 is a square number (5 * 5)",   true,   25),
            Arguments.of("26 isn't a square number",false,  26),
            Arguments.of("random number",false,  150609584)
        );
    }


}