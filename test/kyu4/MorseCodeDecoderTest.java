package kyu4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() throws Exception {
        assertEquals("HEY JUDE",
                MorseCodeDecoder.decodeMorse(
                    MorseCodeDecoder.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"))
                );
    }

    @ParameterizedTest
    @MethodSource
    public void textGetTimeUnit(int expected, int first1sLength, int first0sLength, int nextDiff1sLength,
                                int nextDiff0sLength, String message) {
        assertEquals(expected, MorseCodeDecoder.getTimeUnit(first1sLength, first0sLength, nextDiff1sLength, nextDiff0sLength));
    }

    public static Stream<Arguments> textGetTimeUnit() {
        return Stream.of(
                Arguments.of(1, 1, 7, 3, 0, "E T"),
                Arguments.of(1, 1, 0, 0, 0, "E"),
                Arguments.of(0, 0, 0, 0, 0, "Empty"),
                Arguments.of(2, 2, 0, 0, 0, "E"),
                Arguments.of(3, 3, 0, 0, 0, "T"),
                Arguments.of(1, 3, 7, 1, 0, "T E"),
                Arguments.of(1, 3, 0, 1, 0, "TE"),
                Arguments.of(2, 2, 2, 0, 0, "EE")
        );
    }
}