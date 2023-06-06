package kyu6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringToCamelCaseTest {
    @ParameterizedTest
    @MethodSource("cases")
    public void testCameCaseClever(String expected, String input) {
        assertEquals(expected, StringToCamelCase.toCamelCaseClever(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    public void testCameCaseCleverMatcher(String expected, String input) {
        assertEquals(expected, StringToCamelCase.toCamelCaseCleverMatcher(input));
    }
    @ParameterizedTest
    @MethodSource("cases")
    public void testCameCase(String expected, String input) {
        assertEquals(expected, StringToCamelCase.toCamelCase(input));
    }
    public static Stream<Arguments> cases(){
        return Stream.of(
                Arguments.of("theStealthWarrior", "the_Stealth_Warrior"),
                Arguments.of("theStealthWarrior", "the-Stealth-Warrior"),
                Arguments.of("TheStealthWarrior", "The-Stealth-Warrior"),
                Arguments.of("", ""),
                Arguments.of("t", "t")
        );
    }
}