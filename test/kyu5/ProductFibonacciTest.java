package kyu5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProductFibonacciTest {
    @ParameterizedTest
    @MethodSource("cases")
    void test(long[] expected, long input) {
        assertArrayEquals(expected, ProductFibonacci.productFib(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    void testClever(long[] expected, long input) {
        assertArrayEquals(expected, ProductFibonacci.productFibClever(input));
    }
    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new long[] {55, 89, 1}, 4895),
                Arguments.of(new long[] {89, 144, 0}, 5895),
                Arguments.of(new long[] {1, 1, 1}, 1),
                Arguments.of(new long[] {0, 1, 1}, 0)
        );
    }
}