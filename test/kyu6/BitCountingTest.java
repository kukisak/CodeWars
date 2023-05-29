package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitCountingTest {
    @Test
    public void testGame() {
        assertEquals(5, BitCounting.countBits(1234));
        assertEquals(1, BitCounting.countBits(4));
        assertEquals(3, BitCounting.countBits(7));
        assertEquals(2, BitCounting.countBits(9));
        assertEquals(2, BitCounting.countBits(10));
    }
    @Test
    public void testGameClever() {
        assertEquals(5, BitCounting.countBitsClever(1234));
        assertEquals(1, BitCounting.countBitsClever(4));
        assertEquals(3, BitCounting.countBitsClever(7));
        assertEquals(2, BitCounting.countBitsClever(9));
        assertEquals(2, BitCounting.countBitsClever(10));
    }
    @Test
    public void testGameSmart() {
        assertEquals(5, BitCounting.countBitsSmart(1234));
        assertEquals(1, BitCounting.countBitsSmart(4));
        assertEquals(3, BitCounting.countBitsSmart(7));
        assertEquals(2, BitCounting.countBitsSmart(9));
        assertEquals(2, BitCounting.countBitsSmart(10));
    }
}