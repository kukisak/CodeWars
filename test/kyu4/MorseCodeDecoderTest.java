package kyu4;

import kyu4.MorseCodeDecoder.AnalyzedLength;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static kyu4.MorseCodeDecoder.analyzeLength;
import static kyu4.MorseCodeDecoder.trim0s;
import static org.junit.jupiter.api.Assertions.*;

class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() throws Exception {
//        assertEquals("HEY JUDE",
//                MorseCodeDecoder.decodeMorse(
//                    MorseCodeDecoder.decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"))
//                );
//        assertEquals("I",
//                MorseCodeDecoder.decodeMorse(
//                    MorseCodeDecoder.decodeBits("101"))
//                );
        assertEquals("M",
                MorseCodeDecoder.decodeMorse(
                    MorseCodeDecoder.decodeBits("1110111"))
                );
    }

    @ParameterizedTest
    @MethodSource
    public void testGetTimeUnit(int expected, int first1sLength, int first0sLength, int nextDiff1sLength,
                                int nextDiff0sLength, String message) {
        assertEquals(expected, MorseCodeDecoder.getTimeUnit(new AnalyzedLength(first1sLength, first0sLength, nextDiff1sLength, nextDiff0sLength)));
    }

    public static Stream<Arguments> testGetTimeUnit() {
        return Stream.of(
//                Arguments.of(1, 1, 7, 3, 0, "E T"),
//                Arguments.of(1, 1, 0, 0, 0, "E"),
//                Arguments.of(0, 0, 0, 0, 0, "Empty"),
//                Arguments.of(2, 2, 0, 0, 0, "E"),
//                Arguments.of(3, 3, 0, 0, 0, "T"),
//                Arguments.of(1, 3, 7, 1, 0, "T E"),
//                Arguments.of(1, 3, 0, 1, 0, "TE"),
//                Arguments.of(2, 2, 2, 0, 0, "EE"),
                Arguments.of(1, 3, 1, 0, 0, "M")
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testAnalysedLength(AnalyzedLength expectedAnalyzedLength, String bits) {
        assertEquals(expectedAnalyzedLength, analyzeLength(bits));
    }

    public static Stream<Arguments> testAnalysedLength() {
        return Stream.of(
                Arguments.of(new AnalyzedLength(2, 0, 0, 0), "11"),
                Arguments.of(new AnalyzedLength(2, 4, 0, 0), "110000"),
                Arguments.of(new AnalyzedLength(2, 4, 3, 0), "110000111"),
                Arguments.of(new AnalyzedLength(0, 0, 0, 0), ""),
                Arguments.of(new AnalyzedLength(2, 3, 0, 0), "1100011"),
                Arguments.of(new AnalyzedLength(1, 3, 2, 2), "1000110011")
        );
    }

    @ParameterizedTest
    @MethodSource
    public void testTrim0s(String expected, String input) {
        assertEquals(expected, trim0s(input));
    }

    public static Stream<Arguments> testTrim0s() {
        return Stream.of(
                Arguments.of("11", "11"),
                Arguments.of("11", "0011"),
                Arguments.of("11", "001100"),
                Arguments.of("110011", "00110011"),
                Arguments.of("", "00"),
                Arguments.of("1", "001")
        );
    }
}