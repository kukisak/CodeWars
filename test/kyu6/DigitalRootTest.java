package kyu6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalRootTest {
    @ParameterizedTest
    @MethodSource("testCases")
    public void Test2(int expected, int input) {
        assertEquals(expected, DigitalRoot.digital_root(input));
        assertEquals(expected, DigitalRoot.digital_root_clever(input));
    }

    public static Stream<Arguments> testCases(){
        return Stream.of(
                Arguments.of(7, 16),
                Arguments.of(6, 456)
        );
    }

}