package kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorseCodeDecoderTest {
    @Test
    public void testExampleFromDescription() {
        assertEquals("HEY JUDE", MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
        assertEquals("", MorseCodeDecoder.decode(""));
        assertEquals("E E", MorseCodeDecoder.decode(" .   ."));
    }
}