package kyu7;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static kyu7.AlphabetProduct.alphabet;
import static kyu7.AlphabetProduct.alphabetClever;
import static org.junit.Assert.*;

public class AlphabetProductTest {
    @ParameterizedTest
    @MethodSource("valuesSource")
    public void testAlphabet(int expected, int[] input) {
        assertEquals(expected, alphabet(input));
    }
    @ParameterizedTest
    @MethodSource("valuesSource")
    public void testAlphabetClever(int expected, int[] input) {
        assertEquals(expected, alphabetClever(input));
    }

    private static Stream<Arguments> valuesSource() {
        return Stream.of(
                Arguments.of(4, new int[] {2, 3, 4, 1, 12, 6, 2, 4}),
                Arguments.of(7, new int[] {2, 6, 7, 3, 14, 35, 15, 5}),
                Arguments.of(5, new int[] {20, 10, 6, 5, 4, 3, 2, 12}),
                Arguments.of(7, new int[] {2, 6, 18, 3, 6, 7, 42, 14}),
                Arguments.of(20, new int[] {7, 96, 8, 240, 12, 140, 20, 56}),
                Arguments.of(7, new int[] {20, 30, 6, 7, 4, 42, 28, 5})
        );
    }
}