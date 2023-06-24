package kyu5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HumanReadableTimeTest {
    @ParameterizedTest
    @MethodSource("cases")
    void Tests(String expected, int input, String message) {
        assertEquals(expected, HumanReadableTime.makeReadable(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    void TestsClever(String expected, int input, String message) {
        assertEquals(expected, HumanReadableTime.makeReadableClever(input));
    }

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("00:00:00", 0, "makeReadable(0)"),
                Arguments.of("00:00:05", 5, "makeReadable(5)"),
                Arguments.of("00:01:00", 60, "makeReadable(60)"),
                Arguments.of("23:59:59", 86399, "makeReadable(86399)"),
                Arguments.of("99:59:59", 359999, "makeReadable(359999)")
        );
    }
}