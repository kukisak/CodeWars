package kyu5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RgbToHexTest {
    @ParameterizedTest
    @MethodSource("cases")
    void sampleTests(String expected, int r, int g, int b) {
        assertEquals(expected, RgbToHex.rgb(r, g, b));
    }
    @ParameterizedTest
    @MethodSource("cases")
    void sampleTestsClever(String expected, int r, int g, int b) {
        assertEquals(expected, RgbToHex.rgbClever(r, g, b));
    }

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("000000", 0, 0, 0),
                Arguments.of("010203", 1, 2, 3),
                Arguments.of("FFFFFF", 255, 255, 255),
                Arguments.of("FEFDFC", 254, 253, 252),
                Arguments.of("00FF7D", -20, 275, 125)
        );
    }

}