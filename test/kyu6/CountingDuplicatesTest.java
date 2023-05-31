package kyu6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountingDuplicatesTest {
    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));
    }

    @Test
    public void reallyLongStringContainingDuplicatesReturnsThree() {
        String test = getTest();
        assertEquals(3, CountingDuplicates.duplicateCount(test));
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void casesClever(int expected, String input, String message) {
        assertEquals(expected, CountingDuplicates.duplicateCountClever(input));
    }

    private static String getTest() {
        String testThousandA = new String(new char[1000]).replace('\0', 'a');
        String testHundredB = new String(new char[100]).replace('\0', 'b');
        String testTenC = new String(new char[10]).replace('\0', 'c');
        String test1CapitalA = new String(new char[1]).replace('\0', 'A');
        String test1d = new String(new char[1]).replace('\0', 'd');
        return test1d + test1CapitalA + testTenC +
                testHundredB + testThousandA;
    }

    public static Stream<Arguments> cases() {
        return Stream.of(
            Arguments.of(0, "abcde", "abcdeReturnsZero"),
            Arguments.of(1, "abcdea", "abcdeaReturnsOne"),
            Arguments.of(1, "indivisibility", "indivisibilityReturnsOne"),
            Arguments.of(3, getTest(), "reallyLongStringContainingDuplicatesReturnsThree")
        );
    }

}