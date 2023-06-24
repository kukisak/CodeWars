package kyu5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PigLatinTest {
    @ParameterizedTest
    @MethodSource("cases")
    public void FixedTests(String expected, String input) {
        assertEquals(expected, PigLatin.pigIt(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    public void FixedTestsClever(String expected, String input) {
        assertEquals(expected, PigLatin.pigItClever(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    public void FixedTestsSmart(String expected, String input) {
        assertEquals(expected, PigLatin.pigItSmart(input));
    }

    public static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("igPay atinlay siay oolcay", "Pig latin is cool"),
                Arguments.of("hisTay siay ymay tringsay", "This is my string"),
                Arguments.of("aay", "a"),
                Arguments.of("sdbay", "bsd")
        );
    }

}