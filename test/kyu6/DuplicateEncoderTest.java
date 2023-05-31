package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateEncoderTest {
    @Test
    public void test() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));
    }
    @Test
    public void testBest() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeBest("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeBest("   ()(   "));
    }
    @Test
    public void testClever() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encodeClever("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encodeClever("   ()(   "));
    }
}