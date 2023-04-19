package kyu7;

import org.junit.Test;

import static kyu7.AlphabetProduct.alphabet;
import static org.junit.Assert.*;

public class AlphabetProductTest {
    @Test
    public void test1() {
        assertEquals(alphabet(new int[] {2, 3, 4, 1, 12, 6, 2, 4}), 4 );
    }
    @Test
    public void test2() {
        assertEquals(alphabet(new int[] {2, 6, 7, 3, 14, 35, 15, 5}), 7 );
    }
    @Test
    public void test3() {
        assertEquals(alphabet(new int[] {20, 10, 6, 5, 4, 3, 2, 12}), 5 );
    }
    @Test
    public void test4() {
        assertEquals(alphabet(new int[] {2, 6, 18, 3, 6, 7, 42, 14}), 7 );
    }
    @Test
    public void test5() {
        assertEquals(alphabet(new int[] {7, 96, 8, 240, 12, 140, 20, 56}), 20 );
    }
    @Test
    public void test6() {
        assertEquals(alphabet(new int[] {20, 30, 6, 7, 4, 42, 28, 5}), 7 );
    }


}