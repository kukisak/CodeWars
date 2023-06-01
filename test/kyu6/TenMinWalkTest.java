package kyu6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TenMinWalkTest {
    @ParameterizedTest
    @MethodSource("cases")
    public void Test(String message, boolean expected, char[] input) {
        assertEquals(expected, TenMinWalk.isValid(input), message);
    }

    public static Stream<Arguments> cases(){
        return Stream.of(
            Arguments.of("Should return true", true, new char[] {'n','s','n','s','n','s','n','s','n','s'}),
            Arguments.of("Should return false", false, new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}),
            Arguments.of("Should return false", false, new char[] {'w'}),
            Arguments.of("Should return false", false, new char[] {'n','n','n','s','n','s','n','s','n','s'})
        );
    }

}