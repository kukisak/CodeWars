package kyu7;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SquareDigitsTest {
    @Test
    public void test() {
        assertEquals(811181, new SquareDigits().squareDigits(9119));
        assertEquals(0, new SquareDigits().squareDigits(0));
    }

    @Test
    public void testBest() {
        assertEquals(811181, new SquareDigits().squareDigitsBest(9119));
        assertEquals(0, new SquareDigits().squareDigitsBest(0));
    }
}