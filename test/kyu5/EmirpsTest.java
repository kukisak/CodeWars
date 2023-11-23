package kyu5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmirpsTest {
    @ParameterizedTest
    @MethodSource(value = "emirpsTestCases")
    void emirpsTest(long n, long numberOfEmirpsBelowN, long largestEmirpBelowN, long sumOfEmirpsBelowN) {
        long[] result = Emirps.findEmirp(n);
        assertEquals(numberOfEmirpsBelowN, result[0]);
        assertEquals(largestEmirpBelowN, result[1]);
        assertEquals(sumOfEmirpsBelowN, result[2]);
    }
    
    private static Stream<Arguments> emirpsTestCases() {
        return Stream.of(
                Arguments.of(10, 0, 0, 0),
                Arguments.of(50, 4, 37, 98),
                Arguments.of(100, 8, 97, 418)
        );
    }

}
