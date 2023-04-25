package kyu7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static kyu7.ReverseWords.reverseWords;
import static kyu7.ReverseWords.reverseWordsBest;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsTest {

    @MethodSource("casesSource")
    @ParameterizedTest
    void reverseOrderTest(String expected, String input) {
        assertEquals(expected, reverseWords(input));
    }
    @MethodSource("casesSource")
    @ParameterizedTest
    void reverseOrderBestTest(String expected, String input) {
        assertEquals(expected, reverseWordsBest(input));
    }

    public static Stream<Arguments> casesSource() {
        return Stream.of(
                Arguments.of("drow", "word"),
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of("drow ", "word "),
                Arguments.of("drow  ", "word  "),
                Arguments.of("drow  drow", "word  word"),
                Arguments.of(" drow  drow", " word  word"),
                Arguments.of("ehT kciuq nworb xof spmuj revo eht yzal .god", "The quick brown fox jumps over the lazy dog."),
                Arguments.of("elppa", "apple"),
                Arguments.of("a b c d", "a b c d"),
                Arguments.of("elbuod  decaps  sdrow", "double  spaced  words")
        );
    }
}