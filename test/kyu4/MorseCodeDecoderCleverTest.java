package kyu4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static kyu4.MorseCodeDecoderClever.decodeBits;
import static org.junit.jupiter.api.Assertions.*;

class MorseCodeDecoderCleverTest {
    @Test
    public void testExampleFromDescription() throws Exception {
        assertEquals("HEY JUDE",
                MorseCodeDecoderClever.decodeMorse(
                        decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"))
        );
        assertEquals("I",
                MorseCodeDecoderClever.decodeMorse(
                        decodeBits("101"))
        );
        assertEquals("M",
                MorseCodeDecoderClever.decodeMorse(
                        decodeBits("1110111"))
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testDecodeBits(String expected, String bits, String message) {
        assertEquals(expected, decodeBits(bits));
    }

    public static Stream<Arguments> testDecodeBits() {
        return Stream.of(
                Arguments.of("..", "110011", "E"),
                Arguments.of("..", "000110011000", " E "),
                Arguments.of("--", "1110111", "M"),
                Arguments.of("--", "11111100111111", "M"),
                Arguments.of("--   --", "111011100000001110111", "M M"),
                Arguments.of("-- --", "11101110001110111", "MM")
        );
    }
}